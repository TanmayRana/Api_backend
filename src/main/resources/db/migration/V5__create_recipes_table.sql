CREATE TABLE IF NOT EXISTS "recipes" (
	"id" serial PRIMARY KEY NOT NULL,
	"name" text NOT NULL,
	"ingredients" jsonb NOT NULL,
	"instructions" jsonb NOT NULL,
	"prep_time_minutes" integer NOT NULL,
	"cook_time_minutes" integer NOT NULL,
	"servings" integer NOT NULL,
	"difficulty" text NOT NULL,
	"cuisine" text NOT NULL,
	"calories_per_serving" integer NOT NULL,
	"tags" jsonb NOT NULL,
	"user_id" integer NOT NULL,
	"image" text NOT NULL,
	"rating" real NOT NULL,
	"review_count" integer NOT NULL,
	"meal_type" jsonb NOT NULL
);