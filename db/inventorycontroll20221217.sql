--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.25
-- Dumped by pg_dump version 9.5.25

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: h_apriori_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.h_apriori_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999999999
    CACHE 1;


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: h_apriori; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.h_apriori (
    apriori_id bigint DEFAULT nextval('public.h_apriori_seq'::regclass) NOT NULL,
    organization_id bigint NOT NULL,
    min_support integer NOT NULL,
    min_confidence integer NOT NULL,
    created_by bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    updated_by bigint NOT NULL,
    updated_date timestamp without time zone NOT NULL
);


--
-- Name: h_apriori_association_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.h_apriori_association_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999999999
    CACHE 1;


--
-- Name: h_apriori_association; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.h_apriori_association (
    apriori_association_id bigint DEFAULT nextval('public.h_apriori_association_seq'::regclass) NOT NULL,
    apriori_id bigint NOT NULL,
    rules character varying NOT NULL,
    support integer NOT NULL,
    confidence integer NOT NULL,
    support_confidence integer NOT NULL,
    created_by bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    updated_by bigint NOT NULL,
    updated_date timestamp without time zone NOT NULL
);


--
-- Name: h_apriori_association_item_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.h_apriori_association_item_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999999999
    CACHE 1;


--
-- Name: h_apriori_association_item; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.h_apriori_association_item (
    apriori_association_item_id bigint DEFAULT nextval('public.h_apriori_association_item_seq'::regclass) NOT NULL,
    apriori_association_id bigint NOT NULL,
    item_id bigint NOT NULL,
    created_by bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    updated_by bigint NOT NULL,
    updated_date timestamp without time zone NOT NULL
);


--
-- Name: h_apriori_support_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.h_apriori_support_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999999999
    CACHE 1;


--
-- Name: h_apriori_support; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.h_apriori_support (
    apriori_support_id bigint DEFAULT nextval('public.h_apriori_support_seq'::regclass) NOT NULL,
    apriori_id bigint NOT NULL,
    k_item integer NOT NULL,
    support integer NOT NULL,
    created_by bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    updated_by bigint NOT NULL,
    updated_date timestamp without time zone NOT NULL
);


--
-- Name: h_apriori_support_item_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.h_apriori_support_item_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999999999
    CACHE 1;


--
-- Name: h_apriori_support_item; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.h_apriori_support_item (
    apriori_support_item_id bigint DEFAULT nextval('public.h_apriori_support_item_seq'::regclass) NOT NULL,
    apriori_support_id bigint NOT NULL,
    item_id bigint NOT NULL,
    seq integer NOT NULL,
    created_by bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    updated_by bigint NOT NULL,
    updated_date timestamp without time zone NOT NULL
);


--
-- Name: m_business_parameter_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.m_business_parameter_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999999999
    CACHE 1;


--
-- Name: m_business_parameter; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.m_business_parameter (
    business_parameter_id bigint DEFAULT nextval('public.m_business_parameter_seq'::regclass) NOT NULL,
    code character varying(55) NOT NULL,
    category character varying(55) NOT NULL,
    parameter_string character varying(255) NOT NULL,
    remark character varying(255) NOT NULL,
    created_by bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    updated_by bigint NOT NULL,
    updated_date timestamp without time zone NOT NULL
);


--
-- Name: m_item_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.m_item_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999999999
    CACHE 1;


--
-- Name: m_item; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.m_item (
    item_id bigint DEFAULT nextval('public.m_item_seq'::regclass) NOT NULL,
    item_name character varying NOT NULL,
    unit_code character varying NOT NULL,
    stock integer NOT NULL,
    created_by bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    updated_by bigint NOT NULL,
    updated_date timestamp without time zone NOT NULL
);


--
-- Name: m_organization_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.m_organization_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999999999
    CACHE 1;


--
-- Name: m_organization; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.m_organization (
    organization_id bigint DEFAULT nextval('public.m_organization_seq'::regclass) NOT NULL,
    organization_name character varying NOT NULL,
    created_by bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    updated_by bigint NOT NULL,
    updated_date timestamp without time zone NOT NULL
);


--
-- Name: m_request_item_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.m_request_item_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999999999
    CACHE 1;


--
-- Name: m_request_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.m_request_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999999999
    CACHE 1;


--
-- Name: m_user_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.m_user_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999999999
    CACHE 1;


--
-- Name: m_user; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.m_user (
    user_id bigint DEFAULT nextval('public.m_user_seq'::regclass) NOT NULL,
    organization_id bigint NOT NULL,
    name character varying NOT NULL,
    username character varying NOT NULL,
    password_ character varying NOT NULL,
    created_by bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    updated_by bigint NOT NULL,
    updated_date timestamp without time zone NOT NULL
);


--
-- Name: t_apriori_item_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.t_apriori_item_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999999999
    CACHE 1;


--
-- Name: t_moving_average_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.t_moving_average_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999999999
    CACHE 1;


--
-- Name: t_request; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.t_request (
    request_id bigint DEFAULT nextval('public.m_request_seq'::regclass) NOT NULL,
    status_code character varying NOT NULL,
    created_by bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    updated_by bigint NOT NULL,
    updated_date timestamp without time zone NOT NULL,
    user_id bigint
);


--
-- Name: t_request_item; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.t_request_item (
    request_item_id bigint DEFAULT nextval('public.m_request_item_seq'::regclass) NOT NULL,
    request_id bigint NOT NULL,
    item_id bigint NOT NULL,
    quantity integer NOT NULL,
    created_by bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    updated_by bigint NOT NULL,
    updated_date timestamp without time zone NOT NULL
);


--
-- Data for Name: h_apriori; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.h_apriori (apriori_id, organization_id, min_support, min_confidence, created_by, created_date, updated_by, updated_date) FROM stdin;
21	1	20	50	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
\.


--
-- Data for Name: h_apriori_association; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.h_apriori_association (apriori_association_id, apriori_id, rules, support, confidence, support_confidence, created_by, created_date, updated_by, updated_date) FROM stdin;
133	21	Jika meminta Binder Klip 155,  Flash Disk 16 GB, maka meminta Expanding File Bantex	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
134	21	Jika meminta Documen Tray Besi,  Expanding File Bantex, maka meminta Binder Klip 155	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
135	21	Jika meminta Expanding File Bantex,  Binder Klip 155, maka meminta Documen Tray Besi	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
136	21	Jika meminta Binder Klip 155,  Documen Tray Besi, maka meminta Expanding File Bantex	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
137	21	Jika meminta Flash Disk 16 GB,  Documen Tray Besi,  Expanding File Bantex, maka meminta Binder Klip 155	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
138	21	Jika meminta Documen Tray Besi,  Expanding File Bantex,  Binder Klip 155, maka meminta Flash Disk 16 GB	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
139	21	Jika meminta Expanding File Bantex,  Binder Klip 155,  Flash Disk 16 GB, maka meminta Documen Tray Besi	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
140	21	Jika meminta Binder Klip 155,  Flash Disk 16 GB,  Documen Tray Besi, maka meminta Expanding File Bantex	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
113	21	Jika meminta Flash Disk 16 GB, maka meminta Documen Tray Besi	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
114	21	Jika meminta Documen Tray Besi, maka meminta Flash Disk 16 GB	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
115	21	Jika meminta Flash Disk 16 GB, maka meminta Expanding File Bantex	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
116	21	Jika meminta Expanding File Bantex, maka meminta Flash Disk 16 GB	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
117	21	Jika meminta Flash Disk 16 GB, maka meminta Binder Klip 155	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
118	21	Jika meminta Binder Klip 155, maka meminta Flash Disk 16 GB	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
119	21	Jika meminta Documen Tray Besi, maka meminta Expanding File Bantex	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
120	21	Jika meminta Expanding File Bantex, maka meminta Documen Tray Besi	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
121	21	Jika meminta Documen Tray Besi, maka meminta Binder Klip 155	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
122	21	Jika meminta Binder Klip 155, maka meminta Documen Tray Besi	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
123	21	Jika meminta Expanding File Bantex, maka meminta Binder Klip 155	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
124	21	Jika meminta Binder Klip 155, maka meminta Expanding File Bantex	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
125	21	Jika meminta Flash Disk 16 GB,  Documen Tray Besi, maka meminta Expanding File Bantex	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
126	21	Jika meminta Documen Tray Besi,  Expanding File Bantex, maka meminta Flash Disk 16 GB	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
127	21	Jika meminta Expanding File Bantex,  Flash Disk 16 GB, maka meminta Documen Tray Besi	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
128	21	Jika meminta Flash Disk 16 GB,  Documen Tray Besi, maka meminta Binder Klip 155	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
129	21	Jika meminta Documen Tray Besi,  Binder Klip 155, maka meminta Flash Disk 16 GB	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
130	21	Jika meminta Binder Klip 155,  Flash Disk 16 GB, maka meminta Documen Tray Besi	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
131	21	Jika meminta Flash Disk 16 GB,  Expanding File Bantex, maka meminta Binder Klip 155	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
132	21	Jika meminta Expanding File Bantex,  Binder Klip 155, maka meminta Flash Disk 16 GB	20	100	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
\.


--
-- Data for Name: h_apriori_association_item; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.h_apriori_association_item (apriori_association_item_id, apriori_association_id, item_id, created_by, created_date, updated_by, updated_date) FROM stdin;
305	113	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
306	113	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
307	114	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
308	114	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
309	115	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
310	115	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
311	116	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
312	116	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
313	117	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
314	117	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
315	118	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
316	118	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
317	119	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
318	119	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
319	120	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
320	120	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
321	121	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
322	121	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
323	122	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
324	122	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
325	123	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
326	123	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
327	124	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
328	124	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
329	125	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
330	125	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
331	125	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
332	126	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
333	126	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
334	126	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
335	127	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
336	127	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
337	127	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
338	128	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
339	128	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
340	128	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
341	129	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
342	129	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
343	129	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
344	130	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
345	130	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
346	130	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
347	131	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
348	131	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
349	131	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
350	132	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
351	132	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
352	132	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
353	133	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
354	133	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
355	133	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
356	134	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
357	134	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
358	134	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
359	135	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
360	135	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
361	135	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
362	136	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
363	136	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
364	136	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
365	137	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
366	137	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
367	137	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
368	137	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
369	138	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
370	138	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
371	138	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372	138	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
373	139	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
374	139	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
375	139	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
376	139	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
377	140	12	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
378	140	27	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
379	140	23	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
380	140	25	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
\.


--
-- Name: h_apriori_association_item_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.h_apriori_association_item_seq', 380, true);


--
-- Name: h_apriori_association_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.h_apriori_association_seq', 140, true);


--
-- Name: h_apriori_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.h_apriori_seq', 21, true);


--
-- Data for Name: h_apriori_support; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.h_apriori_support (apriori_support_id, apriori_id, k_item, support, created_by, created_date, updated_by, updated_date) FROM stdin;
72550	21	2	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
72551	21	2	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
72552	21	2	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
72553	21	2	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
72554	21	2	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
72555	21	2	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
72556	21	3	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
72557	21	3	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
72558	21	3	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
72559	21	3	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
72560	21	4	20	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
\.


--
-- Data for Name: h_apriori_support_item; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.h_apriori_support_item (apriori_support_item_id, apriori_support_id, item_id, seq, created_by, created_date, updated_by, updated_date) FROM stdin;
372877	72550	27	1	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372878	72550	23	2	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372879	72551	27	1	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372880	72551	25	2	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372881	72552	27	1	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372882	72552	12	2	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372883	72553	23	1	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372884	72553	25	2	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372885	72554	23	1	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372886	72554	12	2	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372887	72555	25	1	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372888	72555	12	2	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372889	72556	27	1	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372890	72556	23	2	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372891	72556	25	3	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372892	72557	27	1	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372893	72557	23	2	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372894	72557	12	3	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372895	72558	27	1	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372896	72558	25	2	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372897	72558	12	3	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372898	72559	23	1	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372899	72559	25	2	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372900	72559	12	3	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372901	72560	27	1	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372902	72560	23	2	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372903	72560	25	3	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
372904	72560	12	4	16	2022-12-17 15:35:18.283	16	2022-12-17 15:35:18.283
\.


--
-- Name: h_apriori_support_item_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.h_apriori_support_item_seq', 372904, true);


--
-- Name: h_apriori_support_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.h_apriori_support_seq', 72560, true);


--
-- Data for Name: m_business_parameter; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.m_business_parameter (business_parameter_id, code, category, parameter_string, remark, created_by, created_date, updated_by, updated_date) FROM stdin;
1	1	UNIT	Botol		1	2022-12-14 10:23:34.271294	1	2022-12-14 10:23:34.271294
2	2	UNIT	Box		1	2022-12-14 10:23:34.277698	1	2022-12-14 10:23:34.277698
3	3	UNIT	Buah		1	2022-12-14 10:23:34.283926	1	2022-12-14 10:23:34.283926
4	4	UNIT	Dus		1	2022-12-14 10:23:34.286506	1	2022-12-14 10:23:34.286506
5	5	UNIT	Kotak		1	2022-12-14 10:23:34.289936	1	2022-12-14 10:23:34.289936
6	6	UNIT	Lusin		1	2022-12-14 10:23:34.294611	1	2022-12-14 10:23:34.294611
7	7	UNIT	Pad		1	2022-12-14 10:23:34.301365	1	2022-12-14 10:23:34.301365
8	8	UNIT	Pak		1	2022-12-14 10:23:34.305388	1	2022-12-14 10:23:34.305388
9	9	UNIT	Pcs		1	2022-12-14 10:23:34.309204	1	2022-12-14 10:23:34.309204
10	10	UNIT	Rim		1	2022-12-14 10:23:34.314434	1	2022-12-14 10:23:34.314434
11	11	UNIT	Roll		1	2022-12-14 10:23:34.317957	1	2022-12-14 10:23:34.317957
12	12	UNIT	Set		1	2022-12-14 10:23:34.322846	1	2022-12-14 10:23:34.322846
13	13	UNIT	Unit		1	2022-12-14 10:23:34.327192	1	2022-12-14 10:23:34.327192
14	1	REQUEST_STATUS	Open		1	2022-12-14 10:24:19.288515	1	2022-12-14 10:24:19.288515
15	2	REQUEST_STATUS	End		1	2022-12-14 10:24:19.298955	1	2022-12-14 10:24:19.298955
16	3	REQUEST_STATUS	Rejected		1	2022-12-14 10:24:19.303063	1	2022-12-14 10:24:19.303063
\.


--
-- Name: m_business_parameter_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.m_business_parameter_seq', 16, true);


--
-- Data for Name: m_item; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.m_item (item_id, item_name, unit_code, stock, created_by, created_date, updated_by, updated_date) FROM stdin;
1	Amplop Coklat Folio	8	0	1	2022-12-14 10:19:17.128832	1	2022-12-14 10:19:17.128832
2	Amplop Putih Jaya	8	0	1	2022-12-14 10:19:17.13682	1	2022-12-14 10:19:17.13682
3	Amplop Putih Standar	8	8	1	2022-12-14 10:19:17.140658	1	2022-12-14 10:19:17.140658
4	Ballpoint Bolliner Pilot Warna Biru	3	6	1	2022-12-14 10:19:17.145556	1	2022-12-14 10:19:17.145556
5	Ballpoint Faster	3	72	1	2022-12-14 10:19:17.148484	1	2022-12-14 10:19:17.148484
6	Ballpoint kenko	3	147	1	2022-12-14 10:19:17.15297	1	2022-12-14 10:19:17.15297
7	Ballpoint Mix Colour	12	0	1	2022-12-14 10:19:17.155738	1	2022-12-14 10:19:17.155738
8	Batu Baterai Alkalin AA	2	3	1	2022-12-14 10:19:17.162243	1	2022-12-14 10:19:17.162243
9	Batu Baterai Alkalin AAA	3	3	1	2022-12-14 10:19:17.164352	1	2022-12-14 10:19:17.164352
10	Binder Klip 107	4	127	1	2022-12-14 10:19:17.169119	1	2022-12-14 10:19:17.169119
11	Binder Klip 111	2	40	1	2022-12-14 10:19:17.171818	1	2022-12-14 10:19:17.171818
12	Binder Klip 155	2	13	1	2022-12-14 10:19:17.174778	1	2022-12-14 10:19:17.174778
13	Binder Klip 200	2	100	1	2022-12-14 10:19:17.179845	1	2022-12-14 10:19:17.179845
14	Binder Klip 260	2	122	1	2022-12-14 10:19:17.18279	1	2022-12-14 10:19:17.18279
15	Binder Klip No. 105	2	27	1	2022-12-14 10:19:17.187703	1	2022-12-14 10:19:17.187703
16	Box File Bantex	3	9	1	2022-12-14 10:19:17.1915	1	2022-12-14 10:19:17.1915
17	Buku Ekspedisi	3	10	1	2022-12-14 10:19:17.194663	1	2022-12-14 10:19:17.194663
18	Clear Holder Folio 60 Pocket	3	0	1	2022-12-14 10:19:17.198819	1	2022-12-14 10:19:17.198819
19	Continuous Form 9 1/2 x 11 5 Play	2	14	1	2022-12-14 10:19:17.202514	1	2022-12-14 10:19:17.202514
20	Corection Tape	3	16	1	2022-12-14 10:19:17.205736	1	2022-12-14 10:19:17.205736
21	Cutter Besar L 500	3	12	1	2022-12-14 10:19:17.207279	1	2022-12-14 10:19:17.207279
22	Cutter Kecil L 300	3	1	1	2022-12-14 10:19:17.210424	1	2022-12-14 10:19:17.210424
23	Documen Tray Besi	3	8	1	2022-12-14 10:19:17.212987	1	2022-12-14 10:19:17.212987
24	Double Tape 2	3	4	1	2022-12-14 10:19:17.216749	1	2022-12-14 10:19:17.216749
25	Expanding File Bantex	3	4	1	2022-12-14 10:19:17.220417	1	2022-12-14 10:19:17.220417
26	Flasdisk 32 G	3	0	1	2022-12-14 10:19:17.224185	1	2022-12-14 10:19:17.224185
27	Flash Disk 16 GB	3	2	1	2022-12-14 10:19:17.229784	1	2022-12-14 10:19:17.229784
28	Gunting Kertas Besar	3	17	1	2022-12-14 10:19:17.231782	1	2022-12-14 10:19:17.231782
29	Headmacine No. 10	3	1	1	2022-12-14 10:19:17.234408	1	2022-12-14 10:19:17.234408
30	Headmacine No. 3	3	10	1	2022-12-14 10:19:17.236908	1	2022-12-14 10:19:17.236908
31	Hecmacine  HD 50	3	4	1	2022-12-14 10:19:17.240726	1	2022-12-14 10:19:17.240726
32	Isi Headmacine No. 10	8	1	1	2022-12-14 10:19:17.243862	1	2022-12-14 10:19:17.243862
33	Isi Headmacine No. 3	8	4	1	2022-12-14 10:19:17.245682	1	2022-12-14 10:19:17.245682
34	Kalkulator Citizen sdc 868L	3	11	1	2022-12-14 10:19:17.248497	1	2022-12-14 10:19:17.248497
35	Kalkulator Citizen sdc-812bn	3	9	1	2022-12-14 10:19:17.251206	1	2022-12-14 10:19:17.251206
36	Kertas Concorde	8	0	1	2022-12-14 10:19:17.2549	1	2022-12-14 10:19:17.2549
37	Kertas HVS A4 70 gr	10	20	1	2022-12-14 10:19:17.257492	1	2022-12-14 10:19:17.257492
38	Kertas HVS A4 80 gr	10	13	1	2022-12-14 10:19:17.262317	1	2022-12-14 10:19:17.262317
39	Kertas HVS F4 70 gr	10	12	1	2022-12-14 10:19:17.264946	1	2022-12-14 10:19:17.264946
40	Kertas HVS F4 80 gr	10	8	1	2022-12-14 10:19:17.267453	1	2022-12-14 10:19:17.267453
41	Kertas HVS Warna	10	5	1	2022-12-14 10:19:17.269921	1	2022-12-14 10:19:17.269921
42	Kertas Label Stiker Nomor 104	8	4	1	2022-12-14 10:19:17.272359	1	2022-12-14 10:19:17.272359
43	Kertas Label Stiker Nomor 121 	8	9	1	2022-12-14 10:19:17.278204	1	2022-12-14 10:19:17.278204
44	Kertas Post it  Pronto	7	32	1	2022-12-14 10:19:17.280148	1	2022-12-14 10:19:17.280148
45	Kertas Post It No. 654	8	2	1	2022-12-14 10:19:17.282695	1	2022-12-14 10:19:17.282695
46	Kertas Post It No. 655	8	49	1	2022-12-14 10:19:17.284849	1	2022-12-14 10:19:17.284849
47	Kertas Post It Sing Here	7	14	1	2022-12-14 10:19:17.287279	1	2022-12-14 10:19:17.287279
48	Kertas SSP 5 rangkap	3	23	1	2022-12-14 10:19:17.289582	1	2022-12-14 10:19:17.289582
49	Lem UHU	3	3	1	2022-12-14 10:19:17.293103	1	2022-12-14 10:19:17.293103
50	Map Arsip	8	0	1	2022-12-14 10:19:17.296428	1	2022-12-14 10:19:17.296428
51	Map Gantung Fujitsu	4	2	1	2022-12-14 10:19:17.298322	1	2022-12-14 10:19:17.298322
52	Map Plastik Bening F4	6	3	1	2022-12-14 10:19:17.300053	1	2022-12-14 10:19:17.300053
53	Mouse Wereless	3	16	1	2022-12-14 10:19:17.303047	1	2022-12-14 10:19:17.303047
54	Paper Klip / Trogonal No. 5	2	5	1	2022-12-14 10:19:17.305893	1	2022-12-14 10:19:17.305893
55	Paper Klip No. 1	2	95	1	2022-12-14 10:19:17.310968	1	2022-12-14 10:19:17.310968
56	Paper Klip No. 3	2	12	1	2022-12-14 10:19:17.315821	1	2022-12-14 10:19:17.315821
57	Paper Klip Warna Warni	2	10	1	2022-12-14 10:19:17.3179	1	2022-12-14 10:19:17.3179
58	Pembolong Kertas Besar	3	12	1	2022-12-14 10:19:17.321191	1	2022-12-14 10:19:17.321191
59	Pembolong Kertas Kecil	3	12	1	2022-12-14 10:19:17.324509	1	2022-12-14 10:19:17.324509
60	Pencil Fiber Casetel 2B	3	13	1	2022-12-14 10:19:17.328636	1	2022-12-14 10:19:17.328636
61	Penggaris Besi 30 cm	3	3	1	2022-12-14 10:19:17.331751	1	2022-12-14 10:19:17.331751
62	Penghapus Pencil	3	2	1	2022-12-14 10:19:17.336454	1	2022-12-14 10:19:17.336454
63	Penghapus White Board	3	3	1	2022-12-14 10:19:17.33985	1	2022-12-14 10:19:17.33985
64	Plak Band Bening	11	3	1	2022-12-14 10:19:17.342816	1	2022-12-14 10:19:17.342816
65	Plak Band Hitam Besar	11	15	1	2022-12-14 10:19:17.346937	1	2022-12-14 10:19:17.346937
66	Plak Band OPP Daimaru	11	12	1	2022-12-14 10:19:17.349152	1	2022-12-14 10:19:17.349152
67	Push Pin	2	6	1	2022-12-14 10:19:17.352308	1	2022-12-14 10:19:17.352308
68	Rautan Pencil Besar	3	33	1	2022-12-14 10:19:17.358061	1	2022-12-14 10:19:17.358061
69	Spidol Snowman " G " ( H, B,M )	3	32	1	2022-12-14 10:19:17.361636	1	2022-12-14 10:19:17.361636
70	Spidol Snowman "BG " ( H, B,M )	3	34	1	2022-12-14 10:19:17.365578	1	2022-12-14 10:19:17.365578
71	Stabilo Boss	3	0	1	2022-12-14 10:19:17.368199	1	2022-12-14 10:19:17.368199
72	Stationery Desk	3	12	1	2022-12-14 10:19:17.371962	1	2022-12-14 10:19:17.371962
73	Stop Map Diamond	3	0	1	2022-12-14 10:19:17.374093	1	2022-12-14 10:19:17.374093
74	Tinta Epson 003 Black	3	1	1	2022-12-14 10:19:17.380516	1	2022-12-14 10:19:17.380516
75	Tinta Epson 003 Cyan	3	1	1	2022-12-14 10:19:17.383962	1	2022-12-14 10:19:17.383962
76	Tinta Epson 003 Magenta	3	1	1	2022-12-14 10:19:17.386408	1	2022-12-14 10:19:17.386408
77	Tinta Epson 003 Yellow	3	7	1	2022-12-14 10:19:17.389274	1	2022-12-14 10:19:17.389274
78	TINTA EPSON L110	12	1	1	2022-12-14 10:19:17.392277	1	2022-12-14 10:19:17.392277
79	Tinta Epson T001 Black	3	1	1	2022-12-14 10:19:17.39767	1	2022-12-14 10:19:17.39767
80	Tinta Epson T001 Cyan	3	1	1	2022-12-14 10:19:17.400246	1	2022-12-14 10:19:17.400246
81	Tinta Epson T001 Magenta	3	1	1	2022-12-14 10:19:17.403711	1	2022-12-14 10:19:17.403711
82	Tinta Epson T001 Yellow	3	0	1	2022-12-14 10:19:17.407158	1	2022-12-14 10:19:17.407158
83	Tinta HP 680 Black	3	0	1	2022-12-14 10:19:17.41329	1	2022-12-14 10:19:17.41329
84	Tinta HP 680 Colour	3	7	1	2022-12-14 10:19:17.416265	1	2022-12-14 10:19:17.416265
85	Tip Ex Pentel	3	0	1	2022-12-14 10:19:17.421385	1	2022-12-14 10:19:17.421385
86	Toner HP 05A Black	3	1	1	2022-12-14 10:19:17.425307	1	2022-12-14 10:19:17.425307
87	Toner HP LaserJet  85 A Refil	3	1	1	2022-12-14 10:19:17.430337	1	2022-12-14 10:19:17.430337
88	Toner HP LaserJet 12 A	3	1	1	2022-12-14 10:19:17.43427	1	2022-12-14 10:19:17.43427
89	Toner HP LaserJet 202A Black	3	1	1	2022-12-14 10:19:17.436926	1	2022-12-14 10:19:17.436926
90	Toner HP LaserJet 202A Blue	3	1	1	2022-12-14 10:19:17.438906	1	2022-12-14 10:19:17.438906
91	Toner HP LaserJet 202A Red	3	1	1	2022-12-14 10:19:17.44498	1	2022-12-14 10:19:17.44498
92	Toner HP LaserJet 202A Yellow	3	1	1	2022-12-14 10:19:17.447105	1	2022-12-14 10:19:17.447105
93	Toner HP LaserJet 204A Black	3	0	1	2022-12-14 10:19:17.450168	1	2022-12-14 10:19:17.450168
94	Toner HP LaserJet 204A Cyan	3	0	1	2022-12-14 10:19:17.452405	1	2022-12-14 10:19:17.452405
95	Toner HP LaserJet 204A Magenta	3	0	1	2022-12-14 10:19:17.456893	1	2022-12-14 10:19:17.456893
96	Toner HP LaserJet 204A Yellow	3	1	1	2022-12-14 10:19:17.462135	1	2022-12-14 10:19:17.462135
97	Toner HP LaserJet 48A	3	1	1	2022-12-14 10:19:17.463923	1	2022-12-14 10:19:17.463923
98	Toner HP LaserJet 79A	3	0	1	2022-12-14 10:19:17.466318	1	2022-12-14 10:19:17.466318
99	Toner laserJet HP 35 A	3	7	1	2022-12-14 10:19:17.468493	1	2022-12-14 10:19:17.468493
100	Zipper Bag File	3	69	1	2022-12-14 10:19:17.469561	1	2022-12-14 10:19:17.469561
\.


--
-- Name: m_item_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.m_item_seq', 1, false);


--
-- Data for Name: m_organization; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.m_organization (organization_id, organization_name, created_by, created_date, updated_by, updated_date) FROM stdin;
1	Jabatan Fungsional	1	2022-12-14 10:25:40.811736	1	2022-12-14 10:25:40.811736
2	Pembinaan Administrasi dan Kerja Sama Pendidikan Tinggi	1	2022-12-14 10:25:40.816103	1	2022-12-14 10:25:40.816103
3	Pendidikan dan Pelatihan	1	2022-12-14 10:25:40.817617	1	2022-12-14 10:25:40.817617
4	Tata Usaha	1	2022-12-14 10:25:40.822226	1	2022-12-14 10:25:40.822226
\.


--
-- Name: m_organization_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.m_organization_seq', 1, false);


--
-- Name: m_request_item_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.m_request_item_seq', 117, true);


--
-- Name: m_request_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.m_request_seq', 1, false);


--
-- Data for Name: m_user; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.m_user (user_id, organization_id, name, username, password_, created_by, created_date, updated_by, updated_date) FROM stdin;
1	1	Adhi WIrawan	adhi	$2a$12$tfV6I3Ai7dfkcqTXQYtId.qOPXHk6d3Zr8Q6e6p8bLSKoT9HJq12O	1	2022-12-14 10:28:06.49819	1	2022-12-14 10:28:06.49819
2	4	Asri	asri	$2a$12$tfV6I3Ai7dfkcqTXQYtId.qOPXHk6d3Zr8Q6e6p8bLSKoT9HJq12O	1	2022-12-14 10:28:06.506649	1	2022-12-14 10:28:06.506649
3	4	Avin	avin	$2a$12$tfV6I3Ai7dfkcqTXQYtId.qOPXHk6d3Zr8Q6e6p8bLSKoT9HJq12O	1	2022-12-14 10:28:06.509868	1	2022-12-14 10:28:06.509868
4	2	Bidang 3	bidang3	$2a$12$tfV6I3Ai7dfkcqTXQYtId.qOPXHk6d3Zr8Q6e6p8bLSKoT9HJq12O	1	2022-12-14 10:28:06.511845	1	2022-12-14 10:28:06.511845
5	4	Defri	defri	$2a$12$tfV6I3Ai7dfkcqTXQYtId.qOPXHk6d3Zr8Q6e6p8bLSKoT9HJq12O	1	2022-12-14 10:28:06.515115	1	2022-12-14 10:28:06.515115
6	1	Eka Pan Lestari	eka	$2a$12$tfV6I3Ai7dfkcqTXQYtId.qOPXHk6d3Zr8Q6e6p8bLSKoT9HJq12O	1	2022-12-14 10:28:06.520722	1	2022-12-14 10:28:06.520722
7	2	Hillary	hillary	$2a$12$tfV6I3Ai7dfkcqTXQYtId.qOPXHk6d3Zr8Q6e6p8bLSKoT9HJq12O	1	2022-12-14 10:28:06.525037	1	2022-12-14 10:28:06.525037
8	1	Idzar	idzar	$2a$12$tfV6I3Ai7dfkcqTXQYtId.qOPXHk6d3Zr8Q6e6p8bLSKoT9HJq12O	1	2022-12-14 10:28:06.527373	1	2022-12-14 10:28:06.527373
9	3	Jajang_Bidang Diklat I	jajang	$2a$12$tfV6I3Ai7dfkcqTXQYtId.qOPXHk6d3Zr8Q6e6p8bLSKoT9HJq12O	1	2022-12-14 10:28:06.530917	1	2022-12-14 10:28:06.530917
10	3	Joko	joko	$2a$12$tfV6I3Ai7dfkcqTXQYtId.qOPXHk6d3Zr8Q6e6p8bLSKoT9HJq12O	1	2022-12-14 10:28:06.537396	1	2022-12-14 10:28:06.537396
11	1	Kusni	kusni	$2a$12$tfV6I3Ai7dfkcqTXQYtId.qOPXHk6d3Zr8Q6e6p8bLSKoT9HJq12O	1	2022-12-14 10:28:06.542	1	2022-12-14 10:28:06.542
12	4	Lica	lica	$2a$12$tfV6I3Ai7dfkcqTXQYtId.qOPXHk6d3Zr8Q6e6p8bLSKoT9HJq12O	1	2022-12-14 10:28:06.545982	1	2022-12-14 10:28:06.545982
13	4	Pak Budi	budi	$2a$12$tfV6I3Ai7dfkcqTXQYtId.qOPXHk6d3Zr8Q6e6p8bLSKoT9HJq12O	1	2022-12-14 10:28:06.549875	1	2022-12-14 10:28:06.549875
14	4	Stop Opname	stopopname	$2a$12$tfV6I3Ai7dfkcqTXQYtId.qOPXHk6d3Zr8Q6e6p8bLSKoT9HJq12O	1	2022-12-14 10:28:06.553003	1	2022-12-14 10:28:06.553003
15	2	Wahyu Hermansah	wahyu	$2a$12$tfV6I3Ai7dfkcqTXQYtId.qOPXHk6d3Zr8Q6e6p8bLSKoT9HJq12O	1	2022-12-14 10:28:06.558879	1	2022-12-14 10:28:06.558879
16	4	Yanti	yanti	$2a$12$tfV6I3Ai7dfkcqTXQYtId.qOPXHk6d3Zr8Q6e6p8bLSKoT9HJq12O	1	2022-12-14 10:28:06.560826	1	2022-12-14 10:28:06.560826
\.


--
-- Name: m_user_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.m_user_seq', 1, false);


--
-- Name: t_apriori_item_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.t_apriori_item_seq', 1, false);


--
-- Name: t_moving_average_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.t_moving_average_seq', 1, false);


--
-- Data for Name: t_request; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.t_request (request_id, status_code, created_by, created_date, updated_by, updated_date, user_id) FROM stdin;
5	2	1	2022-10-24 00:00:00	1	2022-12-14 10:31:34.847929	3
6	2	1	2022-10-03 00:00:00	1	2022-12-14 10:31:34.851082	9
47	2	1	2022-08-12 00:00:00	1	2022-12-14 10:31:34.97936	7
1	2	1	2022-06-02 00:00:00	1	2022-12-14 10:31:34.83308	4
2	2	1	2022-11-18 00:00:00	1	2022-12-14 10:31:34.838768	9
3	2	1	2022-03-14 00:00:00	1	2022-12-14 10:31:34.842478	3
7	2	1	2022-09-08 00:00:00	1	2022-12-14 10:31:34.854581	5
8	2	1	2022-08-23 00:00:00	1	2022-12-14 10:31:34.857712	6
9	2	1	2022-04-14 00:00:00	1	2022-12-14 10:31:34.863089	5
10	2	1	2022-11-04 00:00:00	1	2022-12-14 10:31:34.865366	9
11	2	1	2022-07-12 00:00:00	1	2022-12-14 10:31:34.867846	2
12	2	1	2022-03-07 00:00:00	1	2022-12-14 10:31:34.869646	16
13	1	1	2022-10-24 00:00:00	1	2022-12-14 10:31:34.872029	11
14	2	1	2022-12-08 00:00:00	1	2022-12-14 10:31:34.87373	9
15	2	1	2022-07-25 00:00:00	1	2022-12-14 10:31:34.8788	15
16	2	1	2022-07-04 00:00:00	1	2022-12-14 10:31:34.882413	9
17	2	1	2022-10-20 00:00:00	1	2022-12-14 10:31:34.885437	7
19	2	1	2022-07-28 00:00:00	1	2022-12-14 10:31:34.889859	9
20	2	1	2022-09-28 00:00:00	1	2022-12-14 10:31:34.891805	13
21	2	1	2022-04-12 00:00:00	1	2022-12-14 10:31:34.8959	9
23	2	1	2022-07-20 00:00:00	1	2022-12-14 10:31:34.901096	9
24	2	1	2022-10-27 00:00:00	1	2022-12-14 10:31:34.904797	10
25	2	1	2022-08-01 00:00:00	1	2022-12-14 10:31:34.907976	14
26	2	1	2022-10-23 00:00:00	1	2022-12-14 10:31:34.911931	16
28	2	1	2022-09-29 00:00:00	1	2022-12-14 10:31:34.918403	8
29	2	1	2022-04-01 00:00:00	1	2022-12-14 10:31:34.92214	12
30	2	1	2022-06-15 00:00:00	1	2022-12-14 10:31:34.925729	16
31	2	1	2022-05-31 00:00:00	1	2022-12-14 10:31:34.928399	8
32	2	1	2022-08-11 00:00:00	1	2022-12-14 10:31:34.930151	3
33	2	1	2022-11-10 00:00:00	1	2022-12-14 10:31:34.932891	3
34	2	1	2022-07-19 00:00:00	1	2022-12-14 10:31:34.936396	9
35	2	1	2022-12-01 00:00:00	1	2022-12-14 10:31:34.941167	9
36	2	1	2022-08-10 00:00:00	1	2022-12-14 10:31:34.944713	7
37	2	1	2022-04-21 00:00:00	1	2022-12-14 10:31:34.946823	9
38	2	1	2022-06-06 00:00:00	1	2022-12-14 10:31:34.95029	1
39	2	1	2022-07-27 00:00:00	1	2022-12-14 10:31:34.953801	16
40	2	1	2022-05-24 00:00:00	1	2022-12-14 10:31:34.956481	5
42	2	1	2022-07-12 00:00:00	1	2022-12-14 10:31:34.967008	9
43	2	1	2022-08-15 00:00:00	1	2022-12-14 10:31:34.969808	15
44	2	1	2022-11-12 00:00:00	1	2022-12-14 10:31:34.971074	16
45	2	1	2022-10-20 00:00:00	1	2022-12-14 10:31:34.973936	9
46	2	1	2022-07-29 00:00:00	1	2022-12-14 10:31:34.976768	5
\.


--
-- Data for Name: t_request_item; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.t_request_item (request_item_id, request_id, item_id, quantity, created_by, created_date, updated_by, updated_date) FROM stdin;
1	21	9	4	1	2022-12-14 10:35:20.454211	1	2022-12-14 10:35:20.454211
2	9	63	1	1	2022-12-14 10:35:20.459938	1	2022-12-14 10:35:20.459938
3	24	4	12	1	2022-12-14 10:35:20.461555	1	2022-12-14 10:35:20.461555
4	42	45	1	1	2022-12-14 10:35:20.465812	1	2022-12-14 10:35:20.465812
5	34	23	1	1	2022-12-14 10:35:20.469569	1	2022-12-14 10:35:20.469569
6	32	4	2	1	2022-12-14 10:35:20.476206	1	2022-12-14 10:35:20.476206
7	13	37	1	1	2022-12-14 10:35:20.479151	1	2022-12-14 10:35:20.479151
8	43	22	1	1	2022-12-14 10:35:20.483619	1	2022-12-14 10:35:20.483619
9	20	97	1	1	2022-12-14 10:35:20.487253	1	2022-12-14 10:35:20.487253
10	6	69	6	1	2022-12-14 10:35:20.493951	1	2022-12-14 10:35:20.493951
11	32	44	3	1	2022-12-14 10:35:20.497483	1	2022-12-14 10:35:20.497483
12	42	19	1	1	2022-12-14 10:35:20.501799	1	2022-12-14 10:35:20.501799
13	43	56	5	1	2022-12-14 10:35:20.508583	1	2022-12-14 10:35:20.508583
14	17	21	1	1	2022-12-14 10:35:20.512921	1	2022-12-14 10:35:20.512921
15	32	10	2	1	2022-12-14 10:35:20.516974	1	2022-12-14 10:35:20.516974
16	16	9	1	1	2022-12-14 10:35:20.521415	1	2022-12-14 10:35:20.521415
17	30	17	3	1	2022-12-14 10:35:20.527659	1	2022-12-14 10:35:20.527659
18	12	90	1	1	2022-12-14 10:35:20.530693	1	2022-12-14 10:35:20.530693
19	12	91	1	1	2022-12-14 10:35:20.534968	1	2022-12-14 10:35:20.534968
20	43	99	2	1	2022-12-14 10:35:20.539383	1	2022-12-14 10:35:20.539383
21	15	37	5	1	2022-12-14 10:35:20.544856	1	2022-12-14 10:35:20.544856
22	34	68	2	1	2022-12-14 10:35:20.548784	1	2022-12-14 10:35:20.548784
23	43	6	5	1	2022-12-14 10:35:20.552574	1	2022-12-14 10:35:20.552574
24	35	4	4	1	2022-12-14 10:35:20.557464	1	2022-12-14 10:35:20.557464
25	45	9	3	1	2022-12-14 10:35:20.5601	1	2022-12-14 10:35:20.5601
26	43	41	4	1	2022-12-14 10:35:20.565947	1	2022-12-14 10:35:20.565947
27	23	69	1	1	2022-12-14 10:35:20.56894	1	2022-12-14 10:35:20.56894
28	43	5	5	1	2022-12-14 10:35:20.570906	1	2022-12-14 10:35:20.570906
29	10	4	11	1	2022-12-14 10:35:20.577433	1	2022-12-14 10:35:20.577433
30	1	97	1	1	2022-12-14 10:35:20.580132	1	2022-12-14 10:35:20.580132
31	45	8	8	1	2022-12-14 10:35:20.584402	1	2022-12-14 10:35:20.584402
32	32	28	3	1	2022-12-14 10:35:20.588455	1	2022-12-14 10:35:20.588455
33	19	44	1	1	2022-12-14 10:35:20.592333	1	2022-12-14 10:35:20.592333
34	9	53	1	1	2022-12-14 10:35:20.595047	1	2022-12-14 10:35:20.595047
35	8	27	1	1	2022-12-14 10:35:20.599208	1	2022-12-14 10:35:20.599208
36	43	86	1	1	2022-12-14 10:35:20.603728	1	2022-12-14 10:35:20.603728
37	15	53	1	1	2022-12-14 10:35:20.610914	1	2022-12-14 10:35:20.610914
38	39	40	1	1	2022-12-14 10:35:20.619499	1	2022-12-14 10:35:20.619499
39	32	61	2	1	2022-12-14 10:35:20.626092	1	2022-12-14 10:35:20.626092
40	20	90	1	1	2022-12-14 10:35:20.630477	1	2022-12-14 10:35:20.630477
41	35	69	3	1	2022-12-14 10:35:20.634271	1	2022-12-14 10:35:20.634271
42	33	37	4	1	2022-12-14 10:35:20.637897	1	2022-12-14 10:35:20.637897
43	43	65	3	1	2022-12-14 10:35:20.643786	1	2022-12-14 10:35:20.643786
44	15	6	10	1	2022-12-14 10:35:20.646531	1	2022-12-14 10:35:20.646531
45	28	9	6	1	2022-12-14 10:35:20.650218	1	2022-12-14 10:35:20.650218
46	25	48	3	1	2022-12-14 10:35:20.653351	1	2022-12-14 10:35:20.653351
47	43	43	5	1	2022-12-14 10:35:20.657877	1	2022-12-14 10:35:20.657877
48	12	96	1	1	2022-12-14 10:35:20.660551	1	2022-12-14 10:35:20.660551
49	43	23	1	1	2022-12-14 10:35:20.663797	1	2022-12-14 10:35:20.663797
50	32	5	2	1	2022-12-14 10:35:20.667174	1	2022-12-14 10:35:20.667174
51	14	8	6	1	2022-12-14 10:35:20.670368	1	2022-12-14 10:35:20.670368
52	43	48	5	1	2022-12-14 10:35:20.67764	1	2022-12-14 10:35:20.67764
53	12	9	1	1	2022-12-14 10:35:20.679902	1	2022-12-14 10:35:20.679902
54	10	69	12	1	2022-12-14 10:35:20.682939	1	2022-12-14 10:35:20.682939
55	20	43	1	1	2022-12-14 10:35:20.685509	1	2022-12-14 10:35:20.685509
56	42	17	2	1	2022-12-14 10:35:20.690627	1	2022-12-14 10:35:20.690627
57	20	91	1	1	2022-12-14 10:35:20.693367	1	2022-12-14 10:35:20.693367
58	2	9	8	1	2022-12-14 10:35:20.697558	1	2022-12-14 10:35:20.697558
59	37	37	3	1	2022-12-14 10:35:20.701298	1	2022-12-14 10:35:20.701298
60	16	8	1	1	2022-12-14 10:35:20.704842	1	2022-12-14 10:35:20.704842
61	46	37	1	1	2022-12-14 10:35:20.707956	1	2022-12-14 10:35:20.707956
62	43	4	1	1	2022-12-14 10:35:20.716068	1	2022-12-14 10:35:20.716068
63	42	4	1	1	2022-12-14 10:35:20.720537	1	2022-12-14 10:35:20.720537
64	46	3	1	1	2022-12-14 10:35:20.725334	1	2022-12-14 10:35:20.725334
65	20	86	1	1	2022-12-14 10:35:20.729193	1	2022-12-14 10:35:20.729193
66	26	37	3	1	2022-12-14 10:35:20.732371	1	2022-12-14 10:35:20.732371
67	19	42	1	1	2022-12-14 10:35:20.735262	1	2022-12-14 10:35:20.735262
68	7	8	1	1	2022-12-14 10:35:20.739208	1	2022-12-14 10:35:20.739208
69	6	4	3	1	2022-12-14 10:35:20.743857	1	2022-12-14 10:35:20.743857
70	29	21	1	1	2022-12-14 10:35:20.747458	1	2022-12-14 10:35:20.747458
71	16	25	2	1	2022-12-14 10:35:20.75051	1	2022-12-14 10:35:20.75051
72	32	3	1	1	2022-12-14 10:35:20.753941	1	2022-12-14 10:35:20.753941
73	29	11	2	1	2022-12-14 10:35:20.7595	1	2022-12-14 10:35:20.7595
74	12	97	1	1	2022-12-14 10:35:20.763496	1	2022-12-14 10:35:20.763496
75	21	8	2	1	2022-12-14 10:35:20.76796	1	2022-12-14 10:35:20.76796
76	32	4	2	1	2022-12-14 10:35:20.771371	1	2022-12-14 10:35:20.771371
77	42	51	1	1	2022-12-14 10:35:20.773836	1	2022-12-14 10:35:20.773836
78	20	89	1	1	2022-12-14 10:35:20.777857	1	2022-12-14 10:35:20.777857
79	29	27	1	1	2022-12-14 10:35:20.784562	1	2022-12-14 10:35:20.784562
80	42	35	1	1	2022-12-14 10:35:20.789239	1	2022-12-14 10:35:20.789239
81	43	46	5	1	2022-12-14 10:35:20.792903	1	2022-12-14 10:35:20.792903
82	20	88	1	1	2022-12-14 10:35:20.795373	1	2022-12-14 10:35:20.795373
83	36	3	1	1	2022-12-14 10:35:20.797753	1	2022-12-14 10:35:20.797753
84	12	89	1	1	2022-12-14 10:35:20.800571	1	2022-12-14 10:35:20.800571
85	3	37	3	1	2022-12-14 10:35:20.802524	1	2022-12-14 10:35:20.802524
86	44	3	6	1	2022-12-14 10:35:20.805783	1	2022-12-14 10:35:20.805783
87	46	20	1	1	2022-12-14 10:35:20.810339	1	2022-12-14 10:35:20.810339
88	11	23	1	1	2022-12-14 10:35:20.814012	1	2022-12-14 10:35:20.814012
89	43	19	2	1	2022-12-14 10:35:20.8163	1	2022-12-14 10:35:20.8163
90	36	37	2	1	2022-12-14 10:35:20.819536	1	2022-12-14 10:35:20.819536
91	43	63	1	1	2022-12-14 10:35:20.821402	1	2022-12-14 10:35:20.821402
92	8	23	5	1	2022-12-14 10:35:20.825406	1	2022-12-14 10:35:20.825406
93	46	37	1	1	2022-12-14 10:35:20.827413	1	2022-12-14 10:35:20.827413
94	12	52	3	1	2022-12-14 10:35:20.830214	1	2022-12-14 10:35:20.830214
95	14	9	1	1	2022-12-14 10:35:20.832736	1	2022-12-14 10:35:20.832736
96	20	86	1	1	2022-12-14 10:35:20.835496	1	2022-12-14 10:35:20.835496
97	29	70	2	1	2022-12-14 10:35:20.839199	1	2022-12-14 10:35:20.839199
98	34	69	1	1	2022-12-14 10:35:20.842216	1	2022-12-14 10:35:20.842216
99	42	67	1	1	2022-12-14 10:35:20.846091	1	2022-12-14 10:35:20.846091
100	42	99	1	1	2022-12-14 10:35:20.84944	1	2022-12-14 10:35:20.84944
101	42	52	1	1	2022-12-14 10:35:20.856496	1	2022-12-14 10:35:20.856496
102	38	52	1	1	2022-12-14 10:35:20.860033	1	2022-12-14 10:35:20.860033
103	43	10	10	1	2022-12-14 10:35:20.862676	1	2022-12-14 10:35:20.862676
104	40	88	1	1	2022-12-14 10:35:20.865816	1	2022-12-14 10:35:20.865816
105	2	8	5	1	2022-12-14 10:35:20.868827	1	2022-12-14 10:35:20.868827
106	42	6	10	1	2022-12-14 10:35:20.871505	1	2022-12-14 10:35:20.871505
107	8	25	2	1	2022-12-14 10:35:20.877579	1	2022-12-14 10:35:20.877579
108	43	51	1	1	2022-12-14 10:35:20.88046	1	2022-12-14 10:35:20.88046
109	43	64	1	1	2022-12-14 10:35:20.884164	1	2022-12-14 10:35:20.884164
110	31	52	1	1	2022-12-14 10:35:20.888043	1	2022-12-14 10:35:20.888043
111	29	12	2	1	2022-12-14 10:35:20.892178	1	2022-12-14 10:35:20.892178
112	8	12	11	1	2022-12-14 10:35:20.897652	1	2022-12-14 10:35:20.897652
113	47	42	1	1	2022-12-14 10:35:20.901985	1	2022-12-14 10:35:20.901985
114	5	37	1	1	2022-12-14 10:35:20.904774	1	2022-12-14 10:35:20.904774
115	39	37	1	1	2022-12-14 10:35:20.907162	1	2022-12-14 10:35:20.907162
116	43	52	2	1	2022-12-14 10:35:20.91196	1	2022-12-14 10:35:20.91196
117	46	9	1	1	2022-12-14 10:35:20.915693	1	2022-12-14 10:35:20.915693
\.


--
-- Name: h_apriori_association_item_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.h_apriori_association_item
    ADD CONSTRAINT h_apriori_association_item_pkey PRIMARY KEY (apriori_association_item_id);


--
-- Name: h_apriori_association_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.h_apriori_association
    ADD CONSTRAINT h_apriori_association_pkey PRIMARY KEY (apriori_association_id);


--
-- Name: h_apriori_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.h_apriori
    ADD CONSTRAINT h_apriori_pkey PRIMARY KEY (apriori_id);


--
-- Name: h_apriori_support_item_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.h_apriori_support_item
    ADD CONSTRAINT h_apriori_support_item_pkey PRIMARY KEY (apriori_support_item_id);


--
-- Name: h_apriori_support_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.h_apriori_support
    ADD CONSTRAINT h_apriori_support_pkey PRIMARY KEY (apriori_support_id);


--
-- Name: m_business_parameter_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.m_business_parameter
    ADD CONSTRAINT m_business_parameter_pkey PRIMARY KEY (business_parameter_id);


--
-- Name: m_item_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.m_item
    ADD CONSTRAINT m_item_pkey PRIMARY KEY (item_id);


--
-- Name: m_organization_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.m_organization
    ADD CONSTRAINT m_organization_pkey PRIMARY KEY (organization_id);


--
-- Name: m_request_item_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.t_request_item
    ADD CONSTRAINT m_request_item_pkey PRIMARY KEY (request_item_id);


--
-- Name: m_request_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.t_request
    ADD CONSTRAINT m_request_pkey PRIMARY KEY (request_id);


--
-- Name: m_user_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.m_user
    ADD CONSTRAINT m_user_pkey PRIMARY KEY (user_id);


--
-- Name: FK_m_request_item_m_request; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.t_request_item
    ADD CONSTRAINT "FK_m_request_item_m_request" FOREIGN KEY (request_id) REFERENCES public.t_request(request_id);


--
-- Name: FK_m_user_m_organization; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.m_user
    ADD CONSTRAINT "FK_m_user_m_organization" FOREIGN KEY (organization_id) REFERENCES public.m_organization(organization_id);


--
-- Name: FK_t_request_m_user; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.t_request
    ADD CONSTRAINT "FK_t_request_m_user" FOREIGN KEY (user_id) REFERENCES public.m_user(user_id);


--
-- PostgreSQL database dump complete
--

