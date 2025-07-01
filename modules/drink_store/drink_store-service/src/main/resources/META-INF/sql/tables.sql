create table DRINK_STORE_Drink (
	id_ LONG not null primary key,
	drinkName VARCHAR(75) null,
	category VARCHAR(75) null,
	price DOUBLE,
	imageUrl VARCHAR(75) null
);

create table DRINK_STORE_OrderDetail (
	id_ LONG not null primary key,
	orderId LONG,
	drinkId LONG,
	number_ INTEGER,
	price DOUBLE,
	size_ VARCHAR(75) null,
	note VARCHAR(75) null
);

create table DRINK_STORE_OrderDrink (
	id_ LONG not null primary key,
	tableId LONG,
	totalAmount DOUBLE,
	orderDate DATE null,
	paid BOOLEAN
);

create table DRINK_STORE_TableDrink (
	id_ LONG not null primary key,
	tableNumber INTEGER,
	seats INTEGER,
	status VARCHAR(75) null
);