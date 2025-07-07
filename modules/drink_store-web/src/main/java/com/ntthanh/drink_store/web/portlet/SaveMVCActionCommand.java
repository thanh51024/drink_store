package com.ntthanh.drink_store.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.ntthanh.drink_store.service.DrinkService;
import com.ntthanh.drink_store.web.constants.DrinkStoreControllerPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.repository.model.FileEntry; 
import com.liferay.portal.kernel.service.ServiceContext; 
import com.liferay.portal.kernel.service.ServiceContextFactory; 
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import java.io.File; 
import java.util.UUID;
@Component(
		immediate = true,
	    service = MVCActionCommand.class,
		property= {
				"javax.portlet.name=" +DrinkStoreControllerPortletKeys.DRINKSTORECONTROLLER,
				"mvc.command.name=/saveDrink"
		}
		)
public class SaveMVCActionCommand extends BaseMVCActionCommand{

    private static final Log _log = LogFactoryUtil.getLog(SaveMVCActionCommand.class);

   
	@SuppressWarnings("deprecation")
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long drinkId = ParamUtil.getLong(actionRequest, "drinkId", 0);
	    String drinkName = ParamUtil.getString(actionRequest, "drinkName", "");
	    String category = ParamUtil.getString(actionRequest, "category", "");
	    Double price = ParamUtil.getDouble(actionRequest, "price", 1000);

	    // giữa lại ảnh cũ nếu k cập nhật ảnh mới
        String oldImageUrl = ParamUtil.getString(actionRequest, "oldImageUrl", ""); 

        // Lấy URL ảnh hiện tại từ form 
        String finalImageUrl = oldImageUrl;


        try {
            // Lấy ThemeDisplay và ServiceContext
            ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long repositoryId = themeDisplay.getScopeGroupId();
            ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); // Lấy ServiceContext chung

            // Tạo folder "DrinkImages" nếu chưa có
            long folderId = 0L; // Mặc định là folder gốc
            try {
                Folder folder = DLAppLocalServiceUtil.getFolder(repositoryId, 0L, "DrinkImages");
                folderId = folder.getFolderId();
            } catch (Exception e) {
                // Nếu folder không tồn tại, tạo mới
                _log.info("Folder 'DrinkImages' not found. Creating it...");
                String externalReferenceCode = "DrinkStore_DrinkImages"; 
                // Một mã tham chiếu cố định hoặc UUID.randomUUID().toString();

                Folder newFolder = DLAppLocalServiceUtil.addFolder(
                    externalReferenceCode, // Tham số MỚI
                    themeDisplay.getUserId(),
                    repositoryId,
                    0L,
                    "DrinkImages",
                    "Thư mục chứa ảnh đồ uống cho ứng dụng",
                    serviceContext
                );
                folderId = newFolder.getFolderId();
            }

            // Xử lý upload ảnh mới
            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
            // Lấy file từ tên input file trong JSP
            File newImageFile = uploadRequest.getFile("newImageFile"); 
            // Tên file gốc được tải lên
            String newFileName = uploadRequest.getFileName("newImageFile"); 

            // Chỉ xử lý upload nếu có file mới được chọn và file đó không rỗng
            if (newImageFile != null && newImageFile.length() > 0) {
            	// Xử lý tên file trùng lặp
                // Tạo một tên file duy nhất bằng cách thêm timestamp hoặc UUID
                newFileName = generateUniqueFileName(newFileName);
                _log.info("New image file detected: " + newFileName);

                // Thêm FileEntry vào Documents and Media
                FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(
                    themeDisplay.getUserId(),               // userId
                    repositoryId,                           // scopeGroupId
                    folderId,                               // folderId của thư mục "DrinkImages"
                    newFileName,                            // sourceFileName
                    MimeTypesUtil.getContentType(newImageFile), // mimeType từ file
                    newFileName,                            // title
                    "Ảnh đồ uống: " + drinkName,            // description
                    "Tải lên từ form",                      // changelog
                    newImageFile,                           // java.io.File object
                    serviceContext                          // serviceContext
                );

                // Lấy URL công khai của ảnh mới
                // Đảm bảo lấy URL đầy đủ và đáng tin cậy
                finalImageUrl = "/documents/" + fileEntry.getRepositoryId() + "/" + fileEntry.getFileEntryId() + "/" + fileEntry.getTitle() + "/" + fileEntry.getUuid();
                _log.info("Uploaded new image. New URL: " + finalImageUrl);
            } else {
                _log.info("No new image file selected. Retaining current URL or leaving blank if new drink.");
                // Nếu không có file mới được tải lên và đây là tạo mới (không phải sửa)
                // Yêu cầu phải có ảnh cho món mới
                if (drinkId == 0 && (finalImageUrl == null || finalImageUrl.isEmpty())) {
                    SessionErrors.add(actionRequest, "image-required-for-new-drink");
                    actionResponse.setRenderParameter("mvcRenderCommandName", "/create/edit"); 
                    return; 
                }
            }

		    System.out.println("save() -> id: " + drinkId + ", name: " + drinkName+"url"+finalImageUrl );
	
		    if (drinkId > 0) {
		        drinkService.updateDrink(drinkId, drinkName, category, price, finalImageUrl);
		    } else {
		        drinkService.addDrink(drinkName, category, price, finalImageUrl);
		    }

	    }catch (Exception e) {
	    	e.printStackTrace();	
	    }
    }
	private DrinkService drinkService;
	
	@Reference(unbind ="-")
	protected void setDrinkService(DrinkService drinkService) {
	
		this.drinkService=drinkService;
	}

	private String generateUniqueFileName(String originalFileName) {
		 String name = "";
		    String extension = "";

		    int dotIndex = originalFileName.lastIndexOf('.');
		    if (dotIndex > 0 && dotIndex < originalFileName.length() - 1) {
		        // Có phần mở rộng
		        name = originalFileName.substring(0, dotIndex);
		        extension = originalFileName.substring(dotIndex + 1);
		    } else {
		        // Không có phần mở rộng hoặc tên file bắt đầu/kết thúc bằng dấu chấm
		        name = originalFileName;
		        extension = ""; // Đảm bảo extension là chuỗi rỗng nếu không có
		    }

		    String uniqueId = UUID.randomUUID().toString().substring(0, 8); // Lấy 8 ký tự đầu của UUID

		    String newFileName;
		    if (!extension.isEmpty()) {
		        newFileName = name + "_" + uniqueId + "." + extension;
		    } else {
		        newFileName = name + "_" + uniqueId;
		    }
		    
		    return newFileName;
	}
}
