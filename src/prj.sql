--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.4
-- Dumped by pg_dump version 9.4.4
-- Started on 2016-01-10 05:01:05

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 196 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2133 (class 0 OID 0)
-- Dependencies: 196
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 173 (class 1259 OID 32843)
-- Name: admin; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE admin (
    ida integer NOT NULL,
    nom character varying(50),
    prenom character varying(50),
    login character varying(50),
    mdp character varying(50),
    tel integer,
    email character varying(100),
    courrier character varying(150),
    msg character varying
);


ALTER TABLE admin OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 32841)
-- Name: admin_ida_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE admin_ida_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE admin_ida_seq OWNER TO postgres;

--
-- TOC entry 2134 (class 0 OID 0)
-- Dependencies: 172
-- Name: admin_ida_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE admin_ida_seq OWNED BY admin.ida;


--
-- TOC entry 193 (class 1259 OID 49467)
-- Name: building; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE building (
    idb integer NOT NULL,
    nam character varying
);


ALTER TABLE building OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 49465)
-- Name: building_idb_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE building_idb_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE building_idb_seq OWNER TO postgres;

--
-- TOC entry 2135 (class 0 OID 0)
-- Dependencies: 192
-- Name: building_idb_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE building_idb_seq OWNED BY building.idb;


--
-- TOC entry 191 (class 1259 OID 49459)
-- Name: classroom; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE classroom (
    idcl integer NOT NULL,
    nam character varying(50),
    cpt integer
);


ALTER TABLE classroom OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 49457)
-- Name: classroom_idcl_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE classroom_idcl_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE classroom_idcl_seq OWNER TO postgres;

--
-- TOC entry 2136 (class 0 OID 0)
-- Dependencies: 190
-- Name: classroom_idcl_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE classroom_idcl_seq OWNED BY classroom.idcl;


--
-- TOC entry 179 (class 1259 OID 49177)
-- Name: cours; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cours (
    idc integer NOT NULL,
    nam character varying(50),
    num_floor integer,
    opt boolean,
    classroom character varying(50),
    gr character varying(50),
    professor character varying,
    formation character(100),
    building character varying,
    dt timestamp with time zone,
    dt_end timestamp with time zone,
    res boolean
);


ALTER TABLE cours OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 49175)
-- Name: cours_idc_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cours_idc_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cours_idc_seq OWNER TO postgres;

--
-- TOC entry 2137 (class 0 OID 0)
-- Dependencies: 178
-- Name: cours_idc_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE cours_idc_seq OWNED BY cours.idc;


--
-- TOC entry 187 (class 1259 OID 49415)
-- Name: floor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE floor (
    idf integer NOT NULL,
    num_floor integer
);


ALTER TABLE floor OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 49413)
-- Name: floor_idf_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE floor_idf_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE floor_idf_seq OWNER TO postgres;

--
-- TOC entry 2138 (class 0 OID 0)
-- Dependencies: 186
-- Name: floor_idf_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE floor_idf_seq OWNED BY floor.idf;


--
-- TOC entry 185 (class 1259 OID 49399)
-- Name: formation; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE formation (
    idf integer NOT NULL,
    nam character varying
);


ALTER TABLE formation OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 49397)
-- Name: formation_idf_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE formation_idf_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE formation_idf_seq OWNER TO postgres;

--
-- TOC entry 2139 (class 0 OID 0)
-- Dependencies: 184
-- Name: formation_idf_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE formation_idf_seq OWNED BY formation.idf;


--
-- TOC entry 181 (class 1259 OID 49277)
-- Name: group; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "group" (
    idg integer NOT NULL,
    num_gr integer
);


ALTER TABLE "group" OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 49275)
-- Name: group_idg_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE group_idg_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE group_idg_seq OWNER TO postgres;

--
-- TOC entry 2140 (class 0 OID 0)
-- Dependencies: 180
-- Name: group_idg_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE group_idg_seq OWNED BY "group".idg;


--
-- TOC entry 175 (class 1259 OID 32863)
-- Name: professor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE professor (
    idp integer NOT NULL,
    nam character varying(50),
    first_nam character varying(50),
    login character varying(50),
    mdp character varying(50),
    tel integer,
    email character varying(100),
    cm character varying(100),
    msg character varying
);


ALTER TABLE professor OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 32861)
-- Name: professor_idp_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE professor_idp_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE professor_idp_seq OWNER TO postgres;

--
-- TOC entry 2141 (class 0 OID 0)
-- Dependencies: 174
-- Name: professor_idp_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE professor_idp_seq OWNED BY professor.idp;


--
-- TOC entry 195 (class 1259 OID 49548)
-- Name: reservation; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE reservation (
    id_r integer NOT NULL,
    dt timestamp without time zone,
    dt_end timestamp without time zone,
    etat_res character varying(100),
    classroom integer
);


ALTER TABLE reservation OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 49546)
-- Name: reservation_id_r_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE reservation_id_r_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE reservation_id_r_seq OWNER TO postgres;

--
-- TOC entry 2142 (class 0 OID 0)
-- Dependencies: 194
-- Name: reservation_id_r_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE reservation_id_r_seq OWNED BY reservation.id_r;


--
-- TOC entry 177 (class 1259 OID 41016)
-- Name: slot; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE slot (
    idsl integer NOT NULL,
    cm character varying(50),
    dt timestamp without time zone,
    dt_end timestamp without time zone,
    formation character varying(50),
    gr character varying
);


ALTER TABLE slot OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 41014)
-- Name: slot_idsl_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE slot_idsl_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE slot_idsl_seq OWNER TO postgres;

--
-- TOC entry 2143 (class 0 OID 0)
-- Dependencies: 176
-- Name: slot_idsl_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE slot_idsl_seq OWNED BY slot.idsl;


--
-- TOC entry 183 (class 1259 OID 49311)
-- Name: student; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE student (
    ids integer NOT NULL,
    nom character varying(50),
    prenom character varying(50),
    login character varying(50),
    mdp character varying(50),
    tel integer,
    email character varying(100),
    num_student integer,
    msg character varying,
    gr integer,
    formation character varying
);


ALTER TABLE student OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 49309)
-- Name: student_ids_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE student_ids_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE student_ids_seq OWNER TO postgres;

--
-- TOC entry 2144 (class 0 OID 0)
-- Dependencies: 182
-- Name: student_ids_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE student_ids_seq OWNED BY student.ids;


--
-- TOC entry 189 (class 1259 OID 49447)
-- Name: universite; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE universite (
    idu integer NOT NULL,
    nam character varying
);


ALTER TABLE universite OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 49445)
-- Name: universite_idu_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE universite_idu_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE universite_idu_seq OWNER TO postgres;

--
-- TOC entry 2145 (class 0 OID 0)
-- Dependencies: 188
-- Name: universite_idu_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE universite_idu_seq OWNED BY universite.idu;


--
-- TOC entry 1955 (class 2604 OID 32846)
-- Name: ida; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY admin ALTER COLUMN ida SET DEFAULT nextval('admin_ida_seq'::regclass);


--
-- TOC entry 1965 (class 2604 OID 49470)
-- Name: idb; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY building ALTER COLUMN idb SET DEFAULT nextval('building_idb_seq'::regclass);


--
-- TOC entry 1964 (class 2604 OID 49462)
-- Name: idcl; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY classroom ALTER COLUMN idcl SET DEFAULT nextval('classroom_idcl_seq'::regclass);


--
-- TOC entry 1958 (class 2604 OID 49180)
-- Name: idc; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cours ALTER COLUMN idc SET DEFAULT nextval('cours_idc_seq'::regclass);


--
-- TOC entry 1962 (class 2604 OID 49418)
-- Name: idf; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY floor ALTER COLUMN idf SET DEFAULT nextval('floor_idf_seq'::regclass);


--
-- TOC entry 1961 (class 2604 OID 49402)
-- Name: idf; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY formation ALTER COLUMN idf SET DEFAULT nextval('formation_idf_seq'::regclass);


--
-- TOC entry 1959 (class 2604 OID 49280)
-- Name: idg; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "group" ALTER COLUMN idg SET DEFAULT nextval('group_idg_seq'::regclass);


--
-- TOC entry 1956 (class 2604 OID 32866)
-- Name: idp; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY professor ALTER COLUMN idp SET DEFAULT nextval('professor_idp_seq'::regclass);


--
-- TOC entry 1966 (class 2604 OID 49551)
-- Name: id_r; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reservation ALTER COLUMN id_r SET DEFAULT nextval('reservation_id_r_seq'::regclass);


--
-- TOC entry 1957 (class 2604 OID 41019)
-- Name: idsl; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY slot ALTER COLUMN idsl SET DEFAULT nextval('slot_idsl_seq'::regclass);


--
-- TOC entry 1960 (class 2604 OID 49314)
-- Name: ids; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student ALTER COLUMN ids SET DEFAULT nextval('student_ids_seq'::regclass);


--
-- TOC entry 1963 (class 2604 OID 49450)
-- Name: idu; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY universite ALTER COLUMN idu SET DEFAULT nextval('universite_idu_seq'::regclass);


--
-- TOC entry 2103 (class 0 OID 32843)
-- Dependencies: 173
-- Data for Name: admin; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY admin (ida, nom, prenom, login, mdp, tel, email, courrier, msg) FROM stdin;
1   SLIMANI Alim    aslimani    alim    770251227   alim.slimani@etu.u-pec.fr   \N  \N
2   VARACCA Daniel  varacca varacca \N  varacca@etu.u-pec.fr    \N  \N
3   TAN Sovana  sovana  sovana  \N  tan@u-pec.fr    \N  \N
4   \N  \N  12  12  \N  \N  \N  \N
\.


--
-- TOC entry 2146 (class 0 OID 0)
-- Dependencies: 172
-- Name: admin_ida_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('admin_ida_seq', 4, true);


--
-- TOC entry 2123 (class 0 OID 49467)
-- Dependencies: 193
-- Data for Name: building; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY building (idb, nam) FROM stdin;
2   P
3   I
4   T
\.


--
-- TOC entry 2147 (class 0 OID 0)
-- Dependencies: 192
-- Name: building_idb_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('building_idb_seq', 4, true);


--
-- TOC entry 2121 (class 0 OID 49459)
-- Dependencies: 191
-- Data for Name: classroom; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY classroom (idcl, nam, cpt) FROM stdin;
\.


--
-- TOC entry 2148 (class 0 OID 0)
-- Dependencies: 190
-- Name: classroom_idcl_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('classroom_idcl_seq', 1, false);


--
-- TOC entry 2109 (class 0 OID 49177)
-- Dependencies: 179
-- Data for Name: cours; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cours (idc, nam, num_floor, opt, classroom, gr, professor, formation, building, dt, dt_end, res) FROM stdin;
3   JAVA    1   t   JAVA    1   \N  \N  \N  \N  2015-08-12 09:00:00+02  f
4   design pattern  1   t   JAVA    1   VARACCA info                                                                                                    \N  \N  2015-08-12 09:00:00+02  f
5   securite    1   f   JAVA    1   TAN info                                                                                                    P   \N  2015-08-12 09:00:00+02  f
2   JAVA    1   t   JAVA    1   Alim    info                                                                                                    C   2016-08-17 05:00:00+02  2015-08-12 09:00:00+02  f
7   \N  \N  \N  JAVA    1   \N  \N  \N  \N  2015-08-12 09:00:00+02  f
8   \N  \N  \N  JAVA    1   \N  \N  \N  \N  2015-08-12 09:00:00+02  f
6   NADA    1   f   PROG    1   Alim    info                                                                                                    3   \N  2015-08-12 09:00:00+02  f
\.


--
-- TOC entry 2149 (class 0 OID 0)
-- Dependencies: 178
-- Name: cours_idc_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cours_idc_seq', 8, true);


--
-- TOC entry 2117 (class 0 OID 49415)
-- Dependencies: 187
-- Data for Name: floor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY floor (idf, num_floor) FROM stdin;
1   2
2   5
3   2
\.


--
-- TOC entry 2150 (class 0 OID 0)
-- Dependencies: 186
-- Name: floor_idf_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('floor_idf_seq', 3, true);


--
-- TOC entry 2115 (class 0 OID 49399)
-- Dependencies: 185
-- Data for Name: formation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY formation (idf, nam) FROM stdin;
1   info
2   info
\.


--
-- TOC entry 2151 (class 0 OID 0)
-- Dependencies: 184
-- Name: formation_idf_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('formation_idf_seq', 2, true);


--
-- TOC entry 2111 (class 0 OID 49277)
-- Dependencies: 181
-- Data for Name: group; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "group" (idg, num_gr) FROM stdin;
\.


--
-- TOC entry 2152 (class 0 OID 0)
-- Dependencies: 180
-- Name: group_idg_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('group_idg_seq', 1, false);


--
-- TOC entry 2105 (class 0 OID 32863)
-- Dependencies: 175
-- Data for Name: professor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY professor (idp, nam, first_nam, login, mdp, tel, email, cm, msg) FROM stdin;
3   TAN Sovana  dva 12  \N  tan@u-pec.fr    PROGR   \N
4   Oualhadj    youssouf    dva 12  615487562   oualhadj@u-pec.fr   PROGR   \N
2   VARACCA Daniel  dvar    14  \N  varacca@u-pec.fr    Prog    \N
5   VARACCA Daniel  dvaracca    11  21648546        Securite    \N
\.


--
-- TOC entry 2153 (class 0 OID 0)
-- Dependencies: 174
-- Name: professor_idp_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('professor_idp_seq', 5, true);


--
-- TOC entry 2125 (class 0 OID 49548)
-- Dependencies: 195
-- Data for Name: reservation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY reservation (id_r, dt, dt_end, etat_res, classroom) FROM stdin;
\.


--
-- TOC entry 2154 (class 0 OID 0)
-- Dependencies: 194
-- Name: reservation_id_r_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('reservation_id_r_seq', 1, false);


--
-- TOC entry 2107 (class 0 OID 41016)
-- Dependencies: 177
-- Data for Name: slot; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY slot (idsl, cm, dt, dt_end, formation, gr) FROM stdin;
3   Suite et serie  2016-01-08 19:43:18.73  2016-01-08 19:43:28.558 Math    Info
4   Math Discrete   2016-01-08 19:50:52.882 2016-01-08 19:51:00.096 Math    Info
6   Modele de calcule   2016-01-08 09:30:00 2016-01-08 12:30:00 Informatique    Master
7   Math discrete   2016-01-08 11:15:00 2016-01-08 12:45:00 Math    Licence 1
1   JAVA    2016-02-09 08:15:00 2016-02-09 08:45:00 Informatique    Master
5   securite    2016-02-09 08:00:00 2016-02-09 08:50:00 Informatique    Master
13  JAVAA   2016-09-15 08:00:00 2016-09-15 11:00:00 Informatique    Master
\.


--
-- TOC entry 2155 (class 0 OID 0)
-- Dependencies: 176
-- Name: slot_idsl_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('slot_idsl_seq', 13, true);


--
-- TOC entry 2113 (class 0 OID 49311)
-- Dependencies: 183
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY student (ids, nom, prenom, login, mdp, tel, email, num_student, msg, gr, formation) FROM stdin;
1   as  as  as  asda    123 azdsfcf 212135  \N  1   inofo
2   sdfsdfgsdgdfg   scdcsdfzrgzdvs  azazdadezaf sfzdgergzef 1515    sdfsfdfbsd  1151646 \N  2   math
\.


--
-- TOC entry 2156 (class 0 OID 0)
-- Dependencies: 182
-- Name: student_ids_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('student_ids_seq', 2, true);


--
-- TOC entry 2119 (class 0 OID 49447)
-- Dependencies: 189
-- Data for Name: universite; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY universite (idu, nam) FROM stdin;
\.


--
-- TOC entry 2157 (class 0 OID 0)
-- Dependencies: 188
-- Name: universite_idu_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('universite_idu_seq', 1, false);


--
-- TOC entry 1968 (class 2606 OID 32848)
-- Name: admin_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (ida);


--
-- TOC entry 1974 (class 2606 OID 49182)
-- Name: cours_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cours
    ADD CONSTRAINT cours_pkey PRIMARY KEY (idc);


--
-- TOC entry 1980 (class 2606 OID 49407)
-- Name: formation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY formation
    ADD CONSTRAINT formation_pkey PRIMARY KEY (idf);


--
-- TOC entry 1988 (class 2606 OID 49475)
-- Name: idb; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY building
    ADD CONSTRAINT idb PRIMARY KEY (idb);


--
-- TOC entry 1986 (class 2606 OID 49464)
-- Name: idcl; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY classroom
    ADD CONSTRAINT idcl PRIMARY KEY (idcl);


--
-- TOC entry 1982 (class 2606 OID 49420)
-- Name: idf; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY floor
    ADD CONSTRAINT idf PRIMARY KEY (idf);


--
-- TOC entry 1976 (class 2606 OID 49282)
-- Name: idgr; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "group"
    ADD CONSTRAINT idgr PRIMARY KEY (idg);


--
-- TOC entry 1984 (class 2606 OID 49455)
-- Name: idu; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY universite
    ADD CONSTRAINT idu PRIMARY KEY (idu);


--
-- TOC entry 1970 (class 2606 OID 32868)
-- Name: professor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY professor
    ADD CONSTRAINT professor_pkey PRIMARY KEY (idp);


--
-- TOC entry 1990 (class 2606 OID 49553)
-- Name: reservation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (id_r);


--
-- TOC entry 1972 (class 2606 OID 41024)
-- Name: slot_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY slot
    ADD CONSTRAINT slot_pkey PRIMARY KEY (idsl);


--
-- TOC entry 1978 (class 2606 OID 49319)
-- Name: student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY student
    ADD CONSTRAINT student_pkey PRIMARY KEY (ids);


--
-- TOC entry 1991 (class 2606 OID 49320)
-- Name: ids; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "group"
    ADD CONSTRAINT ids FOREIGN KEY (idg) REFERENCES student(ids);


--
-- TOC entry 1992 (class 2606 OID 49554)
-- Name: reservation_classroom_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reservation
    ADD CONSTRAINT reservation_classroom_fkey FOREIGN KEY (classroom) REFERENCES classroom(idcl);


--
-- TOC entry 2132 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-01-10 05:01:08

--
-- PostgreSQL database dump complete
--

