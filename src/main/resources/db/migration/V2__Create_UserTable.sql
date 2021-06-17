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
    user_pass character varying(100) NOT NULL,
    first_name character varying(30) NOT NULL,
    last_name character varying(30) NOT NULL,
    user_state int2 NOT NULL,
    created_user email NOT NULL,
    created_time timestamp without time zone NOT NULL,
    modified_user email NOT NULL,
    modified_time timestamp without time zone NOT NULL,
    PRIMARY KEY (user_email)
);
ALTER TABLE public.user_info OWNER to postgres;

-- Comments on pulic.user_info
COMMENT ON COLUMN public.user_info.user_pass IS 'password bcrypt value';
COMMENT ON COLUMN public.user_info.user_state IS '1: ACTIVATE, 2: INACTIVATE, 3: DELETED';

-- Create the first user: walker088@walker088.tw
DELETE FROM public.user_info WHERE user_email = 'walker088@walker088.tw'::email;
INSERT INTO public.user_info(
    user_email,
    user_pass,
    first_name,
    last_name,
    is_activate,
    created_user,
    created_time,
    modified_user,
    modified_time
)
VALUES(
    'walker088@walker088.tw',
    crypt('123', gen_salt('bf', 8)),
    'Walker',
    'Chen',
    1,
    'walker088@walker088.tw',
    CURRENT_TIMESTAMP,
    'walker088@walker088.tw',
    CURRENT_TIMESTAMP
);
