CREATE TABLE IF NOT EXISTS "posts" (
	"id" serial PRIMARY KEY NOT NULL,
	"title" text NOT NULL,
	"body" text NOT NULL,
	"tags" jsonb NOT NULL,
	"reactions" jsonb NOT NULL,
	"views" integer NOT NULL,
	"userId" integer NOT NULL
);