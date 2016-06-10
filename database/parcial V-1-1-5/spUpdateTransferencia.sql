USE [parcial2]
GO

/****** Object:  StoredProcedure [dbo].[spUpdateTransferencia]    Script Date: 06/10/2016 15:25:05 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


create PROCEDURE [dbo].[spUpdateTransferencia]  
	@idTransferencia int,
	@monto decimal(18,0),
	@fechaHora datetime,
	@descripcion varchar(500),	
	@idCuentaOrigen int,
	@idCuentaDestino int
AS
BEGIN TRY
	BEGIN TRAN 
		UPDATE tblTransferencia
		SET  monto = @monto, fechaHora=@fechaHora, descripcion = @descripcion, idCuentaOrigen = @idCuentaOrigen, 
		idCuentaDestino = @idCuentaDestino WHERE idTransferencia = @idTransferencia
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH

GO

