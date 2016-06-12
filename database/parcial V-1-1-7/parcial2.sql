USE [parcial2]
GO

/****** Object:  StoredProcedure [dbo].[spUpdateTransaccion]    Script Date: 10/6/2016 06:56:20 p.m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


ALTER PROCEDURE [dbo].[spUpdateTransaccion]   @idTransaccion int,
										@tipo varchar(50),
										@descripcion text,
										@monto money,
										@fecha date,
										@hora time(7),
										@idCategoria int,
										@idCuenta int
AS
BEGIN
	BEGIN TRY
		BEGIN TRAN
			IF(@tipo = 'Ingreso')
				UPDATE tblCuenta
				SET saldo = saldo - (SELECT monto
									 FROM tblTransaccion
									 WHERE idTransaccion = @idTransaccion)
				WHERE idCuenta = @idCuenta;
			ELSE IF (@tipo = 'Gasto')
				UPDATE tblCuenta
				SET saldo = saldo + (SELECT monto
									 FROM tblTransaccion
									 WHERE idTransaccion = @idTransaccion)
				WHERE idCuenta = @idCuenta;
			UPDATE tblTransaccion
			SET tipo = @tipo, descripcion = @descripcion, monto = @monto, fecha = @fecha, hora = @hora, idCategoria = @idCategoria , idCuenta = @idCuenta
			WHERE idTransaccion = @idTransaccion
			IF(@tipo ='Gasto')
				UPDATE tblCuenta
				SET saldo = saldo - @monto
				WHERE idCuenta = @idCuenta;
			ELSE IF ( @tipo = 'Ingreso')
				UPDATE tblCuenta
				SET saldo = saldo + @monto
				WHERE idCuenta = @idCuenta;
		COMMIT
	END TRY
	BEGIN CATCH
		ROLLBACK
		PRINT ERROR_MESSAGE()
	END CATCH
END

GO


ALTER PROCEDURE [dbo].[spDeleteTransaccion]   @idTransaccion int
AS
BEGIN
	BEGIN TRY
		BEGIN TRAN 
			DECLARE @tipo varchar(50)
			DECLARE @monto money
			DECLARE @idCuenta int
			SELECT @tipo = tipo ,  @monto = monto, @idCuenta = idCuenta
			FROM tblTransaccion
			WHERE idTransaccion = @idTransaccion
			IF(@tipo = 'Ingreso')
				UPDATE tblCuenta
				SET saldo = saldo - @monto
				WHERE idCuenta =@idCuenta
			ELSE IF (@tipo = 'Gasto')
				UPDATE tblCuenta
				SET saldo = saldo + @monto
				WHERE idCuenta =@idCuenta
			DELETE FROM tblTransaccion
			WHERE idTransaccion = @idTransaccion;
		COMMIT
	END TRY
	BEGIN CATCH
		ROLLBACK
		PRINT ERROR_MESSAGE()
	END CATCH
END


GO


ALTER PROCEDURE [dbo].[spInsertTransaccion]   @tipo varchar(50),
										@descripcion text,
										@monto money,
										@fecha date,
										@hora time(7),
										@idCategoria int,
										@idCuenta int
AS
BEGIN
	BEGIN TRY
		BEGIN TRAN 
			INSERT INTO tblTransaccion(tipo, descripcion, monto, fecha, hora, idCategoria, idCuenta)
			VALUES ( @tipo, @descripcion, @monto, @fecha, @hora, @idCategoria, @idCuenta);
			IF(@tipo ='Gasto')
				UPDATE tblCuenta SET saldo = saldo - @monto where idCuenta = @idCuenta;
			else if ( @tipo = 'Ingreso')
				UPDATE tblCuenta SET saldo = saldo + @monto where idCuenta = @idCuenta;
		COMMIT
	END TRY
	BEGIN CATCH
		ROLLBACK
		PRINT ERROR_MESSAGE()
	END CATCH
END


GO

ALTER PROCEDURE [dbo].[spTransacciones]
AS BEGIN
	SELECT idTransaccion, tipo, descripcion, monto, idCategoria, idCuenta, fecha, hora FROM tblTransaccion
END 

GO



ALTER PROCEDURE [dbo].[spTransaccionesByIdCuenta]  @id int
AS BEGIN
	SELECT idTransaccion, tipo, descripcion, monto, idCategoria, idCuenta, fecha, hora FROM tblTransaccion where idCuenta = @id
END 


GO
