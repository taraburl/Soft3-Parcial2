USE [parcial2]
GO

/****** Object:  StoredProcedure [dbo].[spInsertTransferencia]    Script Date: 06/10/2016 15:24:53 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


create PROCEDURE [dbo].[spInsertTransferencia]   
	@monto decimal(18,0),
	@fechaHora datetime,
	@descripcion varchar(500),	
	@idCuentaOrigen int,
	@idCuentaDestino int
AS
BEGIN TRY
	BEGIN TRAN 
		INSERT INTO tblTransferencia(monto, fechaHora, descripcion, idCuentaOrigen,idCuentaDestino)
		VALUES ( @monto, @fechaHora, @descripcion, @idCuentaOrigen, @idCuentaDestino) 
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH

GO

