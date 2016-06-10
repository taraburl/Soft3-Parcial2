USE [parcial2]
GO

/****** Object:  StoredProcedure [dbo].[sbTransferenciaById]    Script Date: 06/10/2016 15:24:23 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



create PROCEDURE [dbo].[spTransferenciaById]  @id int
AS BEGIN
	SELECT * FROM tblTransferencia where idTransferencia = @id
END 

GO

