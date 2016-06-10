USE [parcial2]
GO

/****** Object:  Table [dbo].[tblTransferencia]    Script Date: 06/09/2016 15:43:29 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tblTransferencia]') AND type in (N'U'))
DROP TABLE [dbo].[tblTransferencia]
GO

USE [parcial2]
GO

/****** Object:  Table [dbo].[tblTransferencia]    Script Date: 06/09/2016 15:43:29 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[tblTransferencia](
	[idTransferencia] [int] IDENTITY(1,1) NOT NULL,
	[monto] [decimal](18, 0) NULL,
	[fechaHora] [datetime] NULL,
	[descripcion] [varchar](500) NULL,
	[idCuentaOrigen] [int] NULL,
	[idCuentaDestino] [int] NULL,
 CONSTRAINT [PK_tblTransferencia] PRIMARY KEY CLUSTERED 
(
	[idTransferencia] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

