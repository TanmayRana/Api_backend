CREATE TABLE IF NOT EXISTS "commentusers" (
	"id" integer PRIMARY KEY NOT NULL,
	"username" text NOT NULL,
	"full_name" text NOT NULL
);

CREATE TABLE IF NOT EXISTS "comments" (
	"id" serial PRIMARY KEY NOT NULL,
	"body" text NOT NULL,
	"post_id" integer NOT NULL,
	"likes" integer DEFAULT 0,
	"user_id" integer NOT NULL
);

DO $$ BEGIN
 ALTER TABLE "comments" ADD CONSTRAINT "comments_user_id_commentusers_id_fk" FOREIGN KEY ("user_id") REFERENCES "commentusers"("id") ON DELETE no action ON UPDATE no action;
EXCEPTION
 WHEN duplicate_object THEN null;
END $$;