USE parcial2
GO

CREATE PROCEDURE spTransaccionesByIdCuenta  @id int
AS BEGIN
	SELECT * FROM tblTransaccion where idCuenta = @id
END 

GO
