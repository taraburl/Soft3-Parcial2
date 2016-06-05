USE parcial2;
GO

ALTER TABLE dbo.tblTransaccion 
DROP COLUMN fechaHora;
GO

ALTER TABLE dbo.tblTransaccion  
ADD fecha date NOT NULL, hora time NOT NULL;
GO


--Insertar Categoria
CREATE PROCEDURE spInsertTransaccion   @tipo varchar(50),
										@descripcion text,
										@monto money,
										@fecha date,
										@hora time(7),
										@idCategoria int,
										@idCuenta int
AS
BEGIN TRY
	BEGIN TRAN 
		INSERT INTO tblTransaccion(tipo, descripcion, monto, fecha, hora, idCategoria, idCuenta)
		VALUES ( @tipo, @descripcion, @monto, @fecha, @hora, @idCategoria, @idCuenta) 
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH
GO

--Editar Transaccion
CREATE PROCEDURE spUpdateTransaccion   @idTransaccion int,
										@tipo varchar(50),
										@descripcion text,
										@monto money,
										@fecha date,
										@hora time(7),
										@idCategoria int,
										@idCuenta int
AS
BEGIN TRY
	BEGIN TRAN 
		UPDATE tblTransaccion
		SET tipo = @tipo, descripcion = @descripcion, monto = @monto, fecha = @fecha, hora = @hora, idCategoria = @idCategoria , idCuenta = @idCuenta
		WHERE idTransaccion = @idTransaccion
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH
GO

--ELiminar Transaccion
CREATE PROCEDURE spDeleteTransaccion   @idTransaccion int
AS
BEGIN TRY
	BEGIN TRAN 
		DELETE FROM tblTransaccion
		WHERE idTransaccion = @idTransaccion
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH
GO