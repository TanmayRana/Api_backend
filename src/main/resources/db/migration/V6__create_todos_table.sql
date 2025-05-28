CREATE TABLE IF NOT EXISTS "todos" (
	"id" serial PRIMARY KEY NOT NULL,
	"todo" text NOT NULL,
	"completed" boolean DEFAULT FALSE NOT NULL,
	"userId" integer NOT NULL
);