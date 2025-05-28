CREATE TABLE IF NOT EXISTS "desserts" (
	"id" integer PRIMARY KEY NOT NULL,
	"name" text NOT NULL,
	"price" numeric(10,2) NOT NULL,
	"description" text,
	"img" text,
	"quantity" integer DEFAULT 1
);