DROP TABLE IF EXISTS public.user_info CASCADE;
DROP SEQUENCE IF EXISTS public.user_info_seq;

-- Extensions
CREATE EXTENSION IF NOT EXISTS pgcrypto;
CREATE EXTENSION IF NOT EXISTS citext;
DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'email') THEN
        CREATE DOMAIN email AS citext
        	CHECK ( value ~ '^[a-zA-Z0-9.!#$%&''*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$' );
    END IF;
END$$;

-- User table creation
CREATE TABLE public.user_info
(
    user_email email NOT NULL,
    user_name character varying(40) NOT NULL,
    user_pass character varying(100) NOT NULL,
    is_activate boolean NOT NULL,
    created_user email NOT NULL,
    created_time timestamp without time zone NOT NULL,
    modified_user email NOT NULL,
    modified_time timestamp without time zone NOT NULL,
    PRIMARY KEY (user_email)
);
ALTER TABLE public.user_info OWNER to postgres;

-- Comments on pulic.user_info
COMMENT ON COLUMN public.user_info.user_pass IS 'password bcrypt value';

-- Create the first user: sysadmin
INSERT INTO public.user_info(
    user_email,
    user_name,
    user_pass,
    is_activate,
    created_user,
    created_time,
    modified_user,
    modified_time
)
VALUES(
    'walker088@walker088.tw'
    'walker088',
    crypt('123', gen_salt('bf', 8)),
    true,
    'flyway@v1.sql',
    CURRENT_TIMESTAMP,
    'flyway@v1.sql',
    CURRENT_TIMESTAMP
);
