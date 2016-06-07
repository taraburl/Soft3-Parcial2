USE parcial2
GO


CREATE PROCEDURE spCategoriaPorTipo  @tipo varchar(50)
AS BEGIN
	SELECT * FROM tblCategoria where tipo = @tipo
END 
GO

CREATE PROCEDURE spTransacciones
AS BEGIN
	SELECT * FROM tblTransaccion
END 
GO

CREATE PROCEDURE sbTransaccionesById  @id int
AS BEGIN
	SELECT * FROM tblTransaccion where idTransaccion = @id
END 
GO
