CREATE TABLE IF NOT EXISTS "products" (
	"id" integer PRIMARY KEY NOT NULL,
	"title" text NOT NULL,
	"description" text NOT NULL,
	"category" text NOT NULL,
	"price" numeric(10,2) NOT NULL,
	"discount_percentage" real,
	"rating" real,
	"stock" integer,
	"brand" text,
	"sku" text,
	"weight" real,
	"width" real,
	"height" real,
	"depth" real,
	"warranty_information" text,
	"shipping_information" text,
	"availability_status" text,
	"return_policy" text,
	"minimum_order_quantity" integer,
	"meta" jsonb,
	"tags" jsonb,
	"thumbnail" text
);

CREATE TABLE IF NOT EXISTS "product_images" (
	"id" serial PRIMARY KEY NOT NULL,
	"product_id" integer NOT NULL,
	"url" text NOT NULL
);

CREATE TABLE IF NOT EXISTS "product_reviews" (
	"id" serial PRIMARY KEY NOT NULL,
	"product_id" integer NOT NULL,
	"rating" integer,
	"comment" text,
	"date" timestamp with time zone,
	"reviewer_name" text,
	"reviewer_email" text
);

DO $$ BEGIN
 ALTER TABLE "product_images" ADD CONSTRAINT "product_images_product_id_products_id_fk" FOREIGN KEY ("product_id") REFERENCES "products"("id") ON DELETE no action ON UPDATE no action;
EXCEPTION
 WHEN duplicate_object THEN null;
END $$;

DO $$ BEGIN
 ALTER TABLE "product_reviews" ADD CONSTRAINT "product_reviews_product_id_products_id_fk" FOREIGN KEY ("product_id") REFERENCES "products"("id") ON DELETE no action ON UPDATE no action;
EXCEPTION
 WHEN duplicate_object THEN null;
END $$;