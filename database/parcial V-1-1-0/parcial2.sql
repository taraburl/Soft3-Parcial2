USE parcial2
GO

ALTER TABLE dbo.tblCuenta 
DROP CONSTRAINT FK_tblCuenta_tblUsuario; 
GO

DROP TABLE tblUsuario;
GO

ALTER TABLE dbo.tblCuenta 
DROP COLUMN idUsuario;
GO