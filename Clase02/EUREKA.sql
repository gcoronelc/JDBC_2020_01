
create or replace procedure eureka.cliente_ins (
    p_CHR_CLIECODIGO in CLIENTE.CHR_CLIECODIGO%type
    ,p_VCH_CLIENOMBRE in CLIENTE.VCH_CLIENOMBRE%type
    ,p_VCH_CLIEPATERNO in CLIENTE.VCH_CLIEPATERNO%type
    ,p_VCH_CLIEMATERNO in CLIENTE.VCH_CLIEMATERNO%type
    ,p_CHR_CLIEDNI in CLIENTE.CHR_CLIEDNI%type
    ,p_VCH_CLIEDIRECCION in CLIENTE.VCH_CLIEDIRECCION%type
    ,p_VCH_CLIECIUDAD in CLIENTE.VCH_CLIECIUDAD%type
    ,p_VCH_CLIEEMAIL in CLIENTE.VCH_CLIEEMAIL%type default null 
    ,p_VCH_CLIETELEFONO in CLIENTE.VCH_CLIETELEFONO%type default null 
) 
is
begin
    insert into CLIENTE(
    CHR_CLIECODIGO
    ,VCH_CLIENOMBRE
    ,VCH_CLIEPATERNO
    ,VCH_CLIEMATERNO
    ,CHR_CLIEDNI
    ,VCH_CLIEDIRECCION
    ,VCH_CLIECIUDAD
    ,VCH_CLIEEMAIL
    ,VCH_CLIETELEFONO
    ) values (
    p_CHR_CLIECODIGO
    ,p_VCH_CLIENOMBRE
    ,p_VCH_CLIEPATERNO
    ,p_VCH_CLIEMATERNO
    ,p_CHR_CLIEDNI
    ,p_VCH_CLIEDIRECCION
    ,p_VCH_CLIECIUDAD
    ,p_VCH_CLIEEMAIL
    ,p_VCH_CLIETELEFONO
    );
    commit;
end;
/



CREATE OR REPLACE PROCEDURE EUREKA.SP_SUMA(
    P_N1 IN NUMBER,
    P_N2 IN NUMBER,
    P_SUMA OUT NUMBER
)
IS
BEGIN
    P_SUMA :=  P_N1 + P_N2;
END;
/


select dec_cuensaldo 
from eureka.cuenta
where chr_cuencodigo = '00100001';


create or replace procedure eureka.get_saldo
(
    p_cuenta in varchar2,
    p_saldo out number
)
is
begin
    select dec_cuensaldo into p_saldo
    from eureka.cuenta
    where chr_cuencodigo = p_cuenta;
end;
/


select INT_MOVINUMERO, to_char(dtt_movifecha,'DD/MM/YYYY') fecha,
chr_tipocodigo, dec_moviimporte
from eureka.movimiento
where chr_cuencodigo = '00100001';


CREATE OR REPLACE PROCEDURE EUREKA.GET_MOVIMIENTO
(
    P_CUENTA IN VARCHAR2,
    P_CURSOR OUT NOCOPY SYS_REFCURSOR
)
IS
BEGIN
    OPEN P_CURSOR FOR
    select INT_MOVINUMERO, to_char(dtt_movifecha,'DD/MM/YYYY') fecha,
    chr_tipocodigo, dec_moviimporte
    from eureka.movimiento
    where chr_cuencodigo = P_CUENTA;
END;
/


VARIABLE rc REFCURSOR

EXECUTE EUREKA.GET_MOVIMIENTO('00100002', :RC );

PRINT rc




