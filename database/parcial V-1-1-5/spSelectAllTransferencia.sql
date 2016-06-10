USE [parcial2]
GO

/****** Object:  StoredProcedure [dbo].[spSelectAllTransferencia]    Script Date: 06/10/2016 15:25:46 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


create PROCEDURE [dbo].[spSelectAllTransferencia]
AS BEGIN
	SELECT * FROM tblTransferencia
END 

GO

