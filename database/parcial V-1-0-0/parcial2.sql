USE master
GO

CREATE DATABASE parcial2
GO

USE parcial2
GO

CREATE TABLE [dbo].[tblCategoria](
	[idCategoria] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NULL,
	[tipo] [varchar](50) NULL,
 CONSTRAINT [PK_tblCategoria] PRIMARY KEY CLUSTERED 
(
	[idCategoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[tblCuenta](
	[idCuenta] [int] IDENTITY(1,1) NOT NULL,
	[saldo] [money] NULL,
	[idUsuario] [int] NULL,
 CONSTRAINT [PK_tblCuenta] PRIMARY KEY CLUSTERED 
(
	[idCuenta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[tblTransaccion](
	[idTransaccion] [int] IDENTITY(1,1) NOT NULL,
	[tipo] [varchar](50) NULL,
	[descripcion] [text] NULL,
	[monto] [money] NULL,
	[fechaHora] [datetime] NULL,
	[idCategoria] [int] NULL,
	[idCuenta] [int] NULL,
 CONSTRAINT [PK_tblTransaccion] PRIMARY KEY CLUSTERED 
(
	[idTransaccion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

CREATE TABLE [dbo].[tblTransferencia](
	[idTransferencia] [int] IDENTITY(1,1) NOT NULL,
	[monto] [money] NULL,
	[fechaHora] [datetime] NULL,
	[descripcion] [text] NULL,
	[idCategoria] [int] NULL,
	[idCuentaOrigen] [int] NULL,
	[tipo] [varchar](50) NULL,
	[idCuentaDestino] [int] NULL,
 CONSTRAINT [PK_tblTransferencia] PRIMARY KEY CLUSTERED 
(
	[idTransferencia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

CREATE TABLE [dbo].[tblUsuario](
	[idUsuario] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NULL,
	[telefono] [varchar](50) NULL,
 CONSTRAINT [PK_tblUsuario] PRIMARY KEY CLUSTERED 
(
	[idUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[tblCuenta]  WITH CHECK ADD  CONSTRAINT [FK_tblCuenta_tblUsuario] FOREIGN KEY([idUsuario])
REFERENCES [dbo].[tblUsuario] ([idUsuario])
GO
ALTER TABLE [dbo].[tblTransaccion]  WITH CHECK ADD  CONSTRAINT [FK_tblTransaccion_tblCategoria] FOREIGN KEY([idCategoria])
REFERENCES [dbo].[tblCategoria] ([idCategoria])
GO
ALTER TABLE [dbo].[tblTransaccion]  WITH CHECK ADD  CONSTRAINT [FK_tblTransaccion_tblCuenta] FOREIGN KEY([idCuenta])
REFERENCES [dbo].[tblCuenta] ([idCuenta])
GO
ALTER TABLE [dbo].[tblTransferencia]  WITH CHECK ADD  CONSTRAINT [FK_tblTransferencia_tblCategoria] FOREIGN KEY([idCategoria])
REFERENCES [dbo].[tblCategoria] ([idCategoria])
GO
ALTER TABLE [dbo].[tblTransferencia]  WITH CHECK ADD  CONSTRAINT [FK_tblTransferencia_tblCuenta] FOREIGN KEY([idCuentaDestino])
REFERENCES [dbo].[tblCuenta] ([idCuenta])
GO
ALTER TABLE [dbo].[tblTransferencia]  WITH CHECK ADD  CONSTRAINT [FK_tblTransferencia_tblCuenta1] FOREIGN KEY([idCuentaOrigen])
REFERENCES [dbo].[tblCuenta] ([idCuenta])
GO
