USE [parcial2]
GO

/****** Object:  StoredProcedure [dbo].[spDeleteTransferencia]    Script Date: 06/10/2016 15:24:42 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


create PROCEDURE [dbo].[spDeleteTransferencia]   @idTransferencia int
AS
BEGIN TRY
	BEGIN TRAN 
		DELETE FROM tblTransferencia
		WHERE idTransferencia = @idTransferencia
	COMMIT
END TRY
BEGIN CATCH
	ROLLBACK
	PRINT ERROR_MESSAGE()
END CATCH

GO

