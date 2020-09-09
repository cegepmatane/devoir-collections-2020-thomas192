--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4
-- Dumped by pg_dump version 12.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: montagne; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE montagne WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United Kingdom.1252' LC_CTYPE = 'English_United Kingdom.1252';


ALTER DATABASE montagne OWNER TO postgres;

\connect montagne

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: chainedemontagne; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.chainedemontagne (
    id integer NOT NULL,
    nom text,
    description text
);


ALTER TABLE public.chainedemontagne OWNER TO postgres;

--
-- Name: collection_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.collection_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.collection_id_seq OWNER TO postgres;

--
-- Name: collection_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.collection_id_seq OWNED BY public.chainedemontagne.id;


--
-- Name: sommet; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sommet (
    id integer NOT NULL,
    nom text,
    altitude integer,
    id_chainedemontagne integer
);


ALTER TABLE public.sommet OWNER TO postgres;

--
-- Name: sommet_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sommet_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sommet_id_seq OWNER TO postgres;

--
-- Name: sommet_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sommet_id_seq OWNED BY public.sommet.id;


--
-- Name: chainedemontagne id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chainedemontagne ALTER COLUMN id SET DEFAULT nextval('public.collection_id_seq'::regclass);


--
-- Name: sommet id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sommet ALTER COLUMN id SET DEFAULT nextval('public.sommet_id_seq'::regclass);


--
-- Data for Name: chainedemontagne; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.chainedemontagne VALUES (1, 'Alpes
', 'Les Alpes sont une chaîne de montagnes qui s''étend en Europe, recouvrant la frontière nord de l''Italie, le Sud-Est de la France, Monaco, la Suisse, le Liechtenstein, l''Autriche, le Sud de l''Allemagne et la Slovénie. Les Alpes culminent à 4 809 mètres, au sommet du mont Blanc.');
INSERT INTO public.chainedemontagne VALUES (2, 'Cordillère des Andes', 'La cordillère des Andes, qui s''étend le long de la côte ouest de l''Amérique du Sud, compte parmi les plus grandes chaînes de montagnes du monde. Ses reliefs variés comprennent des glaciers, volcans, plaines, déserts, lacs et forêts. Les montagnes abritent des sites archéologiques de l''époque précolombienne, ainsi qu''une faune diversifiée, avec des chinchillas et des condors. Depuis le Venezuela, au nord, la cordillère traverse la Colombie, l''Équateur, le Pérou, la Bolivie, l''Argentine et le Chili.');
INSERT INTO public.chainedemontagne VALUES (3, 'Himalaya', 'L''Himalaya, ou chaîne de l''Himalaya, est un ensemble de chaînes de montagnes s''étirant sur plus de 2 400 km de long et large de 250 à 400 km, qui sépare le sous-continent indien du plateau tibétain dans le Sud de l''Asie.');
INSERT INTO public.chainedemontagne VALUES (5, 'Pyrénées', 'Les Pyrénées sont une chaîne de montagnes séparant la péninsule Ibérique du reste de l''Europe. Elles s''étendent sur plus de 430 km entre l''Espagne et la France et atteignent plus de 3 400 mètres d''altitude. Des sentiers de randonnée sillonnent toute la longueur de la chaîne, et des parcs nationaux proposent des circuits plus courts. Des dizaines de stations de ski sont situées des deux côtés des Pyrénées. Andorre est un minuscule État souverain au cœur des montagnes.');
INSERT INTO public.chainedemontagne VALUES (6, 'Montagnes Rocheuses', 'Les montagnes Rocheuses s''étendent sur près de 5 000 kilomètres, des provinces de la Colombie-Britannique et de l''Alberta au Canada jusqu''aux États de l''Idaho, du Montana, du Wyoming, du Colorado et enfin du Nouveau-Mexique aux États-Unis. La chaîne offre des zones sauvages spectaculaires, une nature variée et des lacs alpins. Le parc national des montagnes Rocheuses du Colorado est traversé par de nombreux sentiers de randonnée et par la célèbre Trail Ridge Road, un axe routier pittoresque de 77 kilomètres qui culmine à 3 700 mètres d''altitude.');
INSERT INTO public.chainedemontagne VALUES (7, 'Cordillère du Kunlun', 'La cordillère du Kunlun ou Kunlun est une chaîne de hautes montagnes dont l''extrémité occidentale se situe près de la frontière entre la République populaire de Chine et l''Inde, puis qui longe la limite des provinces du Xinjiang et du Tibet et se prolonge à l''est dans celle du Qinghai.');


--
-- Data for Name: sommet; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.sommet VALUES (1, 'Mont Blanc', 4810, 1);
INSERT INTO public.sommet VALUES (2, 'Mont Maudit', 4465, 1);
INSERT INTO public.sommet VALUES (3, 'Dôme du Goûter', 4304, 1);
INSERT INTO public.sommet VALUES (4, 'Mont Blanc du Tacul', 4248, 1);
INSERT INTO public.sommet VALUES (5, 'Grande Rocheuse', 4102, 1);
INSERT INTO public.sommet VALUES (6, 'Aconcagua', 6959, 2);
INSERT INTO public.sommet VALUES (7, 'Pissis ', 6882, 2);
INSERT INTO public.sommet VALUES (8, 'Ojos del Salado', 6864, 2);
INSERT INTO public.sommet VALUES (9, 'Tupungato ', 6800, 2);
INSERT INTO public.sommet VALUES (10, 'Mercedario ', 6770, 2);
INSERT INTO public.sommet VALUES (11, 'Everest', 8848, 3);
INSERT INTO public.sommet VALUES (12, 'Kangchenjunga', 8586, 3);
INSERT INTO public.sommet VALUES (13, 'Lhotse', 8501, 3);
INSERT INTO public.sommet VALUES (14, 'Makalu', 8462, 3);
INSERT INTO public.sommet VALUES (15, 'Nanga Parbat', 8125, 3);
INSERT INTO public.sommet VALUES (16, 'Vignemale ', 3298, 4);
INSERT INTO public.sommet VALUES (17, 'Pic du Marboré
', 3248, 4);
INSERT INTO public.sommet VALUES (18, 'Pic de Perdiguère', 3222, 4);
INSERT INTO public.sommet VALUES (19, 'Pic de Balaïtous', 3144, 4);
INSERT INTO public.sommet VALUES (20, 'Pic de Taillon', 3144, 4);
INSERT INTO public.sommet VALUES (21, 'Pic Gannett', 4207, 5);
INSERT INTO public.sommet VALUES (22, 'Pic Borah', 3861, 5);
INSERT INTO public.sommet VALUES (23, 'Mont Elbert', 4401, 5);
INSERT INTO public.sommet VALUES (24, 'Mont Robson', 3954, 5);
INSERT INTO public.sommet VALUES (25, 'Mont Columbia', 3747, NULL);
INSERT INTO public.sommet VALUES (26, 'Kongur', 7649, 6);
INSERT INTO public.sommet VALUES (27, 'Ulugh Muztagh', 6973, 6);
INSERT INTO public.sommet VALUES (28, 'Muztagata', 7546, 6);
INSERT INTO public.sommet VALUES (29, 'Yuzhu Peak', 6224, 6);
INSERT INTO public.sommet VALUES (30, 'Bukadaban Feng', 6860, 6);


--
-- Name: collection_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.collection_id_seq', 12, true);


--
-- Name: sommet_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sommet_id_seq', 30, true);


--
-- Name: chainedemontagne collection_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chainedemontagne
    ADD CONSTRAINT collection_pkey PRIMARY KEY (id);


--
-- Name: sommet sommet_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sommet
    ADD CONSTRAINT sommet_pkey PRIMARY KEY (id);


--
-- Name: sommet fk_chainedemontagne_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sommet
    ADD CONSTRAINT fk_chainedemontagne_id FOREIGN KEY (id_chainedemontagne) REFERENCES public.chainedemontagne(id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


--
-- PostgreSQL database dump complete
--

