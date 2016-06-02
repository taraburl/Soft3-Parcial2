USE [master]
GO
/****** Object:  Database [parcial2]    Script Date: 1/6/2016 11:35:37 p.m. ******/
CREATE DATABASE [parcial2]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'parcial2', FILENAME = N'c:\Program Files (x86)\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\parcial2.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'parcial2_log', FILENAME = N'c:\Program Files (x86)\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\parcial2_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [parcial2] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [parcial2].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [parcial2] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [parcial2] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [parcial2] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [parcial2] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [parcial2] SET ARITHABORT OFF 
GO
ALTER DATABASE [parcial2] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [parcial2] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [parcial2] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [parcial2] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [parcial2] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [parcial2] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [parcial2] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [parcial2] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [parcial2] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [parcial2] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [parcial2] SET  DISABLE_BROKER 
GO
ALTER DATABASE [parcial2] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [parcial2] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [parcial2] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [parcial2] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [parcial2] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [parcial2] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [parcial2] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [parcial2] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [parcial2] SET  MULTI_USER 
GO
ALTER DATABASE [parcial2] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [parcial2] SET DB_CHAINING OFF 
GO
ALTER DATABASE [parcial2] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [parcial2] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [parcial2]
GO
/****** Object:  Table [dbo].[tblCategoria]    Script Date: 1/6/2016 11:35:37 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
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
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblCuenta]    Script Date: 1/6/2016 11:35:38 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[tblTransaccion]    Script Date: 1/6/2016 11:35:38 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblTransaccion](
	[idTransaccion] [int] IDENTITY(1,1) NOT NULL,
	[tipo] [varchar](50) NULL,
	[monto] [money] NULL,
	[fechaHora] [datetime] NULL,
	[idCategoria] [int] NULL,
	[idCuenta] [int] NULL,
 CONSTRAINT [PK_tblTransaccion] PRIMARY KEY CLUSTERED 
(
	[idTransaccion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblTransferencia]    Script Date: 1/6/2016 11:35:38 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblTransferencia](
	[idTransferencia] [int] IDENTITY(1,1) NOT NULL,
	[monto] [money] NULL,
	[fechaHora] [datetime] NULL,
	[descripcion] [text] NULL,
	[idCategoria] [int] NULL,
	[idCuentaOrigen] [int] NULL,
	[idCuentaDestino] [int] NULL,
 CONSTRAINT [PK_tblTransferencia] PRIMARY KEY CLUSTERED 
(
	[idTransferencia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblUsuario]    Script Date: 1/6/2016 11:35:38 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
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
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[tblCuenta]  WITH CHECK ADD  CONSTRAINT [FK_tblCuenta_tblUsuario] FOREIGN KEY([idUsuario])
REFERENCES [dbo].[tblUsuario] ([idUsuario])
GO
ALTER TABLE [dbo].[tblCuenta] CHECK CONSTRAINT [FK_tblCuenta_tblUsuario]
GO
ALTER TABLE [dbo].[tblTransaccion]  WITH CHECK ADD  CONSTRAINT [FK_tblTransaccion_tblCategoria] FOREIGN KEY([idCategoria])
REFERENCES [dbo].[tblCategoria] ([idCategoria])
GO
ALTER TABLE [dbo].[tblTransaccion] CHECK CONSTRAINT [FK_tblTransaccion_tblCategoria]
GO
ALTER TABLE [dbo].[tblTransaccion]  WITH CHECK ADD  CONSTRAINT [FK_tblTransaccion_tblCuenta] FOREIGN KEY([idCuenta])
REFERENCES [dbo].[tblCuenta] ([idCuenta])
GO
ALTER TABLE [dbo].[tblTransaccion] CHECK CONSTRAINT [FK_tblTransaccion_tblCuenta]
GO
ALTER TABLE [dbo].[tblTransferencia]  WITH CHECK ADD  CONSTRAINT [FK_tblTransferencia_tblCategoria] FOREIGN KEY([idCategoria])
REFERENCES [dbo].[tblCategoria] ([idCategoria])
GO
ALTER TABLE [dbo].[tblTransferencia] CHECK CONSTRAINT [FK_tblTransferencia_tblCategoria]
GO
ALTER TABLE [dbo].[tblTransferencia]  WITH CHECK ADD  CONSTRAINT [FK_tblTransferencia_tblCuenta] FOREIGN KEY([idCuentaDestino])
REFERENCES [dbo].[tblCuenta] ([idCuenta])
GO
ALTER TABLE [dbo].[tblTransferencia] CHECK CONSTRAINT [FK_tblTransferencia_tblCuenta]
GO
ALTER TABLE [dbo].[tblTransferencia]  WITH CHECK ADD  CONSTRAINT [FK_tblTransferencia_tblCuenta1] FOREIGN KEY([idCuentaOrigen])
REFERENCES [dbo].[tblCuenta] ([idCuenta])
GO
ALTER TABLE [dbo].[tblTransferencia] CHECK CONSTRAINT [FK_tblTransferencia_tblCuenta1]
GO
USE [master]
GO
ALTER DATABASE [parcial2] SET  READ_WRITE 
GO
