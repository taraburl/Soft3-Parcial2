use parcial2
go

CREATE PROCEDURE spinsertarcuenta   @saldo money,
									@nombrecuenta varchar(20)
AS
BEGIN TRY
	BEGIN TRAN 
		INSERT INTO tblCuenta(saldo,nombreCuenta)
		VALUES (@saldo, @nombrecuenta)
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH
GO


CREATE PROCEDURE speliminarcuenta   @id int
AS
BEGIN TRY
	BEGIN TRAN 
	delete from tblTransaccion where idCuenta = @id;
	delete from tblTransferencia where idCuentaOrigen = @id;
	delete from tblTransferencia where idCuentaDestino = @id;
	delete from tblCuenta where idCuenta=@id;
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH
GO


CREATE PROCEDURE spactualizarcuenta @id int,
									@saldo money,
									@nombrecuenta varchar(20)
AS
BEGIN TRY
	BEGIN TRAN 
		update tblCuenta 
			set saldo = @saldo, nombreCuenta = @nombreCuenta
		where idCuenta = @id
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH
GO


create procedure spselectCuenta
as begin 
select * from tblCuenta
end
go


create procedure spselectCuentaByid @id int
as begin 
select * from tblCuenta where idCuenta = @id
end
go




CREATE PROCEDURE spinsertarcategoria   @nombre varchar(50),
									   @tipo varchar(50)
AS
BEGIN TRY
	BEGIN TRAN 
		INSERT INTO tblCategoria(nombre,tipo)
		VALUES (@nombre, @tipo)
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH
GO


CREATE PROCEDURE speliminarcategoria   @id int
AS
BEGIN TRY
	BEGIN TRAN 
	if not exists (select idCategoria from tblTransaccion where idCategoria = @id)
		delete from tblCategoria where idCategoria = @id	
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH
GO


CREATE PROCEDURE spactualizarcategoria  @id int,
										@nombre varchar(50),
										@tipo varchar(50)
AS
BEGIN TRY
	BEGIN TRAN 
		update tblCategoria 
			set nombre = @nombre, tipo = @tipo
		where idCategoria = @id
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH
GO


create procedure spselectCategoria
as begin 
select * from tblCategoria
end
go


create procedure spselectCategoriaByid @id int
as begin 
select * from tblCategoria where idCategoria = @id
end
go
