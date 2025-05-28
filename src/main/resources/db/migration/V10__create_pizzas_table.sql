CREATE TABLE IF NOT EXISTS "pizzas" (
	"id" integer PRIMARY KEY NOT NULL,
	"name" text NOT NULL,
	"veg" boolean NOT NULL,
	"price" numeric(10,2) NOT NULL,
	"description" text,
	"quantity" integer DEFAULT 1,
	"img" text
);

CREATE TABLE IF NOT EXISTS "size_and_crust_options" (
	"id" serial PRIMARY KEY NOT NULL,
	"pizza_id" integer NOT NULL,
	"type" text NOT NULL,
	"price" numeric(10,2) NOT NULL
);

DO $$ BEGIN
 ALTER TABLE "size_and_crust_options" ADD CONSTRAINT "size_and_crust_options_pizza_id_pizzas_id_fk" FOREIGN KEY ("pizza_id") REFERENCES "pizzas"("id") ON DELETE no action ON UPDATE no action;
EXCEPTION
 WHEN duplicate_object THEN null;
END $$;