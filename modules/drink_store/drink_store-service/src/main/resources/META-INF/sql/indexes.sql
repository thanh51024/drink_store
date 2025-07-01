create index IX_EBA7226B on DRINK_STORE_Drink (category[$COLUMN_LENGTH:75$]);
create index IX_6463B34C on DRINK_STORE_Drink (drinkName[$COLUMN_LENGTH:75$], category[$COLUMN_LENGTH:75$]);
create index IX_BF497260 on DRINK_STORE_Drink (price);

create index IX_4B7E7A19 on DRINK_STORE_OrderDetail (orderId);

create index IX_252D2C77 on DRINK_STORE_OrderDrink (orderDate);

create index IX_6A11E7E9 on DRINK_STORE_TableDrink (seats);
create index IX_F1AA8A9B on DRINK_STORE_TableDrink (status[$COLUMN_LENGTH:75$]);
create index IX_2435DC92 on DRINK_STORE_TableDrink (tableNumber);