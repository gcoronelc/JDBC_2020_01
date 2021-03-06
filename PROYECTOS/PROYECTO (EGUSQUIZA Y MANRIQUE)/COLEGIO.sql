--------------------------------------------------------
-- Archivo creado  - martes-febrero-11-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ALUMNO
--------------------------------------------------------

  CREATE TABLE "PROYECTO"."ALUMNO" 
   (	"ALUM_ID" NUMBER(8,0), 
	"ALUM_DNI" VARCHAR2(8 BYTE), 
	"ALUM_NOM" VARCHAR2(40 BYTE), 
	"ALUM_APE" VARCHAR2(40 BYTE), 
	"ALUM_FEC" DATE, 
	"ALUM_DIR" VARCHAR2(80 BYTE), 
	"ALUM_TEL" VARCHAR2(80 BYTE), 
	"ALUM_COR" VARCHAR2(80 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table CURSO
--------------------------------------------------------

  CREATE TABLE "PROYECTO"."CURSO" 
   (	"CURS_ID" NUMBER(8,0), 
	"CURS_NOM" VARCHAR2(20 BYTE), 
	"FECH_INI" DATE, 
	"FECH_FIN" DATE, 
	"CURS_DIA" VARCHAR2(50 BYTE), 
	"CURS_HOR" VARCHAR2(20 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table NOTA
--------------------------------------------------------

  CREATE TABLE "PROYECTO"."NOTA" 
   (	"NOTA_ID" NUMBER(8,0), 
	"ALUM_ID" NUMBER(8,0), 
	"CURS_ID" NUMBER(8,0), 
	"NOTA_PROM" NUMBER(2,0), 
	"NOTA_EST" CHAR(1 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PROFESOR
--------------------------------------------------------

  CREATE TABLE "PROYECTO"."PROFESOR" 
   (	"PROF_ID" NUMBER(8,0), 
	"PROF_DNI" VARCHAR2(8 BYTE), 
	"PROF_NOM" VARCHAR2(40 BYTE), 
	"PROF_APE" VARCHAR2(40 BYTE), 
	"PROF_FEC" DATE, 
	"PROF_DIR" VARCHAR2(80 BYTE), 
	"PROF_TEL" VARCHAR2(80 BYTE), 
	"PROF_COR" VARCHAR2(80 BYTE), 
	"CURS_ID" NUMBER(8,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into PROYECTO.ALUMNO
SET DEFINE OFF;
Insert into PROYECTO.ALUMNO (ALUM_ID,ALUM_DNI,ALUM_NOM,ALUM_APE,ALUM_FEC,ALUM_DIR,ALUM_TEL,ALUM_COR) values ('1','74986714','Cristian','Egusquiza',to_date('25/06/00','DD/MM/RR'),'Mz Q Lt 9b Asoc. Se�or de los Milagros, SMP','949179614','cristian06250@gmail.com');
Insert into PROYECTO.ALUMNO (ALUM_ID,ALUM_DNI,ALUM_NOM,ALUM_APE,ALUM_FEC,ALUM_DIR,ALUM_TEL,ALUM_COR) values ('2','74158754','Jhonny','Manrique',to_date('02/05/00','DD/MM/RR'),'dsbfbfdsbfd','947845741','jhonny123@gmail.com');
Insert into PROYECTO.ALUMNO (ALUM_ID,ALUM_DNI,ALUM_NOM,ALUM_APE,ALUM_FEC,ALUM_DIR,ALUM_TEL,ALUM_COR) values ('3','74125487','Liz','Sanchez',to_date('02/08/98','DD/MM/RR'),'??????????????','949142574','liz.g161@gmail.com');
Insert into PROYECTO.ALUMNO (ALUM_ID,ALUM_DNI,ALUM_NOM,ALUM_APE,ALUM_FEC,ALUM_DIR,ALUM_TEL,ALUM_COR) values ('4','74125474','Estefano','Gonzales',to_date('18/02/01','DD/MM/RR'),'????????????','949154784','estgon516@gmail.com');
Insert into PROYECTO.ALUMNO (ALUM_ID,ALUM_DNI,ALUM_NOM,ALUM_APE,ALUM_FEC,ALUM_DIR,ALUM_TEL,ALUM_COR) values ('5','74128412','Maria','Perez',to_date('15/01/01','DD/MM/RR'),'Santa Maria C2 Lt 5L','941254741','mariap151@gmail.com');
REM INSERTING into PROYECTO.CURSO
SET DEFINE OFF;
Insert into PROYECTO.CURSO (CURS_ID,CURS_NOM,FECH_INI,FECH_FIN,CURS_DIA,CURS_HOR) values ('1','Aritmetica',to_date('11/02/20','DD/MM/RR'),to_date('11/12/20','DD/MM/RR'),'Martes','7:00 - 8:30');
Insert into PROYECTO.CURSO (CURS_ID,CURS_NOM,FECH_INI,FECH_FIN,CURS_DIA,CURS_HOR) values ('2','Fisica',to_date('18/02/20','DD/MM/RR'),to_date('18/12/20','DD/MM/RR'),'Viernes','12:30- 1:00');
Insert into PROYECTO.CURSO (CURS_ID,CURS_NOM,FECH_INI,FECH_FIN,CURS_DIA,CURS_HOR) values ('3','Literatura',to_date('20/02/20','DD/MM/RR'),to_date('20/12/20','DD/MM/RR'),'Miercoles','10:30 - 12:00');
Insert into PROYECTO.CURSO (CURS_ID,CURS_NOM,FECH_INI,FECH_FIN,CURS_DIA,CURS_HOR) values ('4','Geografia',to_date('10/03/20','DD/MM/RR'),to_date('10/12/20','DD/MM/RR'),'Miercoles','1:00- 2:30');
Insert into PROYECTO.CURSO (CURS_ID,CURS_NOM,FECH_INI,FECH_FIN,CURS_DIA,CURS_HOR) values ('5','Historia',to_date('20/03/20','DD/MM/RR'),to_date('20/12/20','DD/MM/RR'),'Lunes','1:00- 2:30');
Insert into PROYECTO.CURSO (CURS_ID,CURS_NOM,FECH_INI,FECH_FIN,CURS_DIA,CURS_HOR) values ('6','Java',to_date('10/09/20','DD/MM/RR'),to_date('11/10/20','DD/MM/RR'),'Miercoles','8:30 - 10:00');
REM INSERTING into PROYECTO.NOTA
SET DEFINE OFF;
Insert into PROYECTO.NOTA (NOTA_ID,ALUM_ID,CURS_ID,NOTA_PROM,NOTA_EST) values ('1','2','1','15','A');
Insert into PROYECTO.NOTA (NOTA_ID,ALUM_ID,CURS_ID,NOTA_PROM,NOTA_EST) values ('2','1','2','8','D');
Insert into PROYECTO.NOTA (NOTA_ID,ALUM_ID,CURS_ID,NOTA_PROM,NOTA_EST) values ('3','1','3','18','A');
Insert into PROYECTO.NOTA (NOTA_ID,ALUM_ID,CURS_ID,NOTA_PROM,NOTA_EST) values ('4','3','3','11','D');
Insert into PROYECTO.NOTA (NOTA_ID,ALUM_ID,CURS_ID,NOTA_PROM,NOTA_EST) values ('5','2','3','20','A');
Insert into PROYECTO.NOTA (NOTA_ID,ALUM_ID,CURS_ID,NOTA_PROM,NOTA_EST) values ('6','1','1','10','D');
Insert into PROYECTO.NOTA (NOTA_ID,ALUM_ID,CURS_ID,NOTA_PROM,NOTA_EST) values ('7','3','2','20','A');
Insert into PROYECTO.NOTA (NOTA_ID,ALUM_ID,CURS_ID,NOTA_PROM,NOTA_EST) values ('8','4','3','10','D');
Insert into PROYECTO.NOTA (NOTA_ID,ALUM_ID,CURS_ID,NOTA_PROM,NOTA_EST) values ('9','5','4','20','A');
Insert into PROYECTO.NOTA (NOTA_ID,ALUM_ID,CURS_ID,NOTA_PROM,NOTA_EST) values ('10','4','2','2','D');
Insert into PROYECTO.NOTA (NOTA_ID,ALUM_ID,CURS_ID,NOTA_PROM,NOTA_EST) values ('11','5','1','14','A');
Insert into PROYECTO.NOTA (NOTA_ID,ALUM_ID,CURS_ID,NOTA_PROM,NOTA_EST) values ('13','2','5','9','D');
Insert into PROYECTO.NOTA (NOTA_ID,ALUM_ID,CURS_ID,NOTA_PROM,NOTA_EST) values ('14','1','4','20','A');
Insert into PROYECTO.NOTA (NOTA_ID,ALUM_ID,CURS_ID,NOTA_PROM,NOTA_EST) values ('15','2','6','18','A');
REM INSERTING into PROYECTO.PROFESOR
SET DEFINE OFF;
Insert into PROYECTO.PROFESOR (PROF_ID,PROF_DNI,PROF_NOM,PROF_APE,PROF_FEC,PROF_DIR,PROF_TEL,PROF_COR,CURS_ID) values ('1','78756714','Juan','Perez',to_date('20/08/90','DD/MM/RR'),'??????????????????','941257484','juanp1564@gmail.com','1');
Insert into PROYECTO.PROFESOR (PROF_ID,PROF_DNI,PROF_NOM,PROF_APE,PROF_FEC,PROF_DIR,PROF_TEL,PROF_COR,CURS_ID) values ('2','78745142','Maria','Gonzales',to_date('18/02/80','DD/MM/RR'),'??????????????????','945123654','mgonza4125@gmail.com','2');
Insert into PROYECTO.PROFESOR (PROF_ID,PROF_DNI,PROF_NOM,PROF_APE,PROF_FEC,PROF_DIR,PROF_TEL,PROF_COR,CURS_ID) values ('3','71254879','Roberto','Bravo',to_date('28/04/88','DD/MM/RR'),'??????????????????','945124784','rbravo1285@gmail.com','3');
Insert into PROYECTO.PROFESOR (PROF_ID,PROF_DNI,PROF_NOM,PROF_APE,PROF_FEC,PROF_DIR,PROF_TEL,PROF_COR,CURS_ID) values ('4','74125384','Rodrigo','Romero',to_date('18/05/90','DD/MM/RR'),'??????????????','952147845','rodrigor51651@gmail.com','4');
Insert into PROYECTO.PROFESOR (PROF_ID,PROF_DNI,PROF_NOM,PROF_APE,PROF_FEC,PROF_DIR,PROF_TEL,PROF_COR,CURS_ID) values ('5','71285415','Danae','Rivera',to_date('20/07/82','DD/MM/RR'),'??????????????','934587412','dana_02417@gmail.com','5');
--------------------------------------------------------
--  Constraints for Table PROFESOR
--------------------------------------------------------

  ALTER TABLE "PROYECTO"."PROFESOR" MODIFY ("PROF_ID" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."PROFESOR" MODIFY ("PROF_DNI" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."PROFESOR" MODIFY ("PROF_NOM" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."PROFESOR" MODIFY ("PROF_APE" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."PROFESOR" MODIFY ("PROF_FEC" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."PROFESOR" MODIFY ("PROF_DIR" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."PROFESOR" MODIFY ("PROF_TEL" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."PROFESOR" MODIFY ("PROF_COR" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."PROFESOR" MODIFY ("CURS_ID" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."PROFESOR" ADD PRIMARY KEY ("PROF_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CURSO
--------------------------------------------------------

  ALTER TABLE "PROYECTO"."CURSO" MODIFY ("CURS_ID" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."CURSO" MODIFY ("CURS_NOM" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."CURSO" MODIFY ("FECH_INI" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."CURSO" MODIFY ("FECH_FIN" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."CURSO" MODIFY ("CURS_DIA" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."CURSO" MODIFY ("CURS_HOR" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."CURSO" ADD PRIMARY KEY ("CURS_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table NOTA
--------------------------------------------------------

  ALTER TABLE "PROYECTO"."NOTA" MODIFY ("NOTA_ID" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."NOTA" MODIFY ("ALUM_ID" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."NOTA" MODIFY ("CURS_ID" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."NOTA" MODIFY ("NOTA_PROM" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."NOTA" MODIFY ("NOTA_EST" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."NOTA" ADD PRIMARY KEY ("NOTA_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ALUMNO
--------------------------------------------------------

  ALTER TABLE "PROYECTO"."ALUMNO" MODIFY ("ALUM_ID" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."ALUMNO" MODIFY ("ALUM_DNI" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."ALUMNO" MODIFY ("ALUM_NOM" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."ALUMNO" MODIFY ("ALUM_APE" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."ALUMNO" MODIFY ("ALUM_FEC" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."ALUMNO" MODIFY ("ALUM_DIR" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."ALUMNO" MODIFY ("ALUM_TEL" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."ALUMNO" MODIFY ("ALUM_COR" NOT NULL ENABLE);
 
  ALTER TABLE "PROYECTO"."ALUMNO" ADD PRIMARY KEY ("ALUM_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table NOTA
--------------------------------------------------------

  ALTER TABLE "PROYECTO"."NOTA" ADD CONSTRAINT "FK_NOTA_ALUM_ID" FOREIGN KEY ("ALUM_ID")
	  REFERENCES "PROYECTO"."ALUMNO" ("ALUM_ID") ENABLE;
 
  ALTER TABLE "PROYECTO"."NOTA" ADD CONSTRAINT "FK_NOTA_CURS_ID" FOREIGN KEY ("CURS_ID")
	  REFERENCES "PROYECTO"."CURSO" ("CURS_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PROFESOR
--------------------------------------------------------

  ALTER TABLE "PROYECTO"."PROFESOR" ADD CONSTRAINT "FK_PROFESOR_CURS_ID" FOREIGN KEY ("CURS_ID")
	  REFERENCES "PROYECTO"."CURSO" ("CURS_ID") ENABLE;
