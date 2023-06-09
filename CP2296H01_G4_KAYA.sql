USE [master]
GO
/****** Object:  Database [CP2296H01_G4_KAYA]    Script Date: 4/28/2023 9:52:17 AM ******/
CREATE DATABASE [CP2296H01_G4_KAYA]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'KAYA', FILENAME = N'E:\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\KAYA.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'KAYA_log', FILENAME = N'E:\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\KAYA_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [CP2296H01_G4_KAYA].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET ARITHABORT OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET  ENABLE_BROKER 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET RECOVERY FULL 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET  MULTI_USER 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET DB_CHAINING OFF 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'CP2296H01_G4_KAYA', N'ON'
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET QUERY_STORE = OFF
GO
USE [CP2296H01_G4_KAYA]
GO
/****** Object:  Table [dbo].[Brands]    Script Date: 4/28/2023 9:52:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Brands](
	[BrandID] [int] IDENTITY(100,1) NOT NULL,
	[BrandName] [varchar](150) NOT NULL,
	[Description] [varchar](500) NOT NULL,
	[Website] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[BrandID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 4/28/2023 9:52:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[CategoryID] [int] IDENTITY(1000,1) NOT NULL,
	[CategoryName] [varchar](150) NOT NULL,
	[Description] [varchar](500) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customers]    Script Date: 4/28/2023 9:52:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customers](
	[CustomerID] [int] IDENTITY(10000,1) NOT NULL,
	[Fullname] [varchar](50) NULL,
	[Username] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[Address] [varchar](150) NULL,
	[PhoneNumber] [varchar](13) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Avatar] [varchar](255) NULL,
	[Status] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employees]    Script Date: 4/28/2023 9:52:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employees](
	[EmployeeID] [int] IDENTITY(1000,1) NOT NULL,
	[Fullname] [varchar](50) NOT NULL,
	[Username] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[Address] [varchar](100) NOT NULL,
	[PhoneNumber] [varchar](13) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Status] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[EmployeeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[FeedbackDetails]    Script Date: 4/28/2023 9:52:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FeedbackDetails](
	[FeedbackID] [int] NOT NULL,
	[ProductID] [int] NOT NULL,
	[FeedbackContent] [varchar](500) NULL,
	[Reviews] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[FeedbackID] ASC,
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Feedbacks]    Script Date: 4/28/2023 9:52:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Feedbacks](
	[FeedbackID] [int] IDENTITY(10000,1) NOT NULL,
	[CreationDate] [datetime] NOT NULL,
	[CustomerID] [int] NOT NULL,
	[Status] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[FeedbackID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 4/28/2023 9:52:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[OrderID] [int] NOT NULL,
	[ProductID] [int] NOT NULL,
	[Quantity] [int] NOT NULL,
	[UnitPrice] [money] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC,
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 4/28/2023 9:52:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderID] [int] IDENTITY(10000,1) NOT NULL,
	[CustomerID] [int] NOT NULL,
	[EmployeeID] [int] NOT NULL,
	[OrderDate] [datetime] NOT NULL,
	[TotalAmount] [int] NOT NULL,
	[TotalPrice] [money] NOT NULL,
	[PaymentMethod] [varchar](50) NOT NULL,
	[Note] [varchar](255) NULL,
	[Status] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Owner]    Script Date: 4/28/2023 9:52:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Owner](
	[Username] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[Email] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 4/28/2023 9:52:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[ProductID] [int] IDENTITY(10000,1) NOT NULL,
	[ProductName] [varchar](150) NOT NULL,
	[Description] [varchar](500) NOT NULL,
	[CategoryID] [int] NOT NULL,
	[SupplierID] [int] NOT NULL,
	[BrandID] [int] NOT NULL,
	[UnitPrice] [money] NOT NULL,
	[Image] [varchar](255) NULL,
	[Quantity] [int] NOT NULL,
	[PromotionStatus] [int] NOT NULL,
	[Status] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Promotions]    Script Date: 4/28/2023 9:52:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Promotions](
	[PromotionID] [int] IDENTITY(100,1) NOT NULL,
	[ProductID] [int] NOT NULL,
	[PromotionName] [varchar](150) NOT NULL,
	[PromotionDate] [date] NOT NULL,
	[Discount] [int] NOT NULL,
	[AmountApplyPromotion] [money] NOT NULL,
	[Note] [varchar](255) NULL,
	[DateEnd] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[PromotionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Suppliers]    Script Date: 4/28/2023 9:52:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Suppliers](
	[SupplierID] [int] IDENTITY(100,1) NOT NULL,
	[CompanyName] [varchar](50) NOT NULL,
	[PhoneNumber] [varchar](13) NOT NULL,
	[Address] [varchar](100) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Website] [varchar](20) NULL,
	[Status] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[SupplierID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Brands] ON 

INSERT [dbo].[Brands] ([BrandID], [BrandName], [Description], [Website]) VALUES (102, N'Dunelm Group', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', N'DunelmGroup.com.vn')
INSERT [dbo].[Brands] ([BrandID], [BrandName], [Description], [Website]) VALUES (104, N'Ashley', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', N'Ashley.com.vn')
INSERT [dbo].[Brands] ([BrandID], [BrandName], [Description], [Website]) VALUES (105, N'Aaron', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', N'Aaron.vn')
INSERT [dbo].[Brands] ([BrandID], [BrandName], [Description], [Website]) VALUES (112, N'Row', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', N'Row.vn')
SET IDENTITY_INSERT [dbo].[Brands] OFF
GO
SET IDENTITY_INSERT [dbo].[Categories] ON 

INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (1000, N'Furniture', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (1001, N'Outdoor', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (1002, N'Baedding and Bath', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (1004, N'Decor and Pillows', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (1005, N'Rugs', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (1006, N'Lighting', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (1016, N'Home Improvement', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (1017, N'Organization', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName], [Description]) VALUES (1018, N'Pet', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.')
SET IDENTITY_INSERT [dbo].[Categories] OFF
GO
SET IDENTITY_INSERT [dbo].[Customers] ON 

INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10000, N'Ngo Thi Cam Duyen', N'duyenngo', N'duyenngo123', N'My Tu, Can Tho', N'0387090621', N'duyenngo@gmail.com', N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1682647193/der5lnigulrmfvszxoqn.webp', 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10005, N'Ngo Thi Cam Duyen', N'ngocamduyen', N'ngocamduyen', N'Ninh Kieu Can Tho', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1682647241/vt3hffgtcstpqvkiqwy7.jpg', 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10008, N'Ngo Thi Cam Duyen', N'nobita', N'nobita', N'Ninh Kieu Can Tho', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', NULL, 0)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10015, N'Duyen Ngo Thi Cam', N'duyenngo123', N'Ntcd@123', N'Soc Trang', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', NULL, 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10016, N'Duyen Ngo Thi Cam', N'duyenngo2002', N'Duyenngo@2k2', N'Soc Trang', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', NULL, 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10017, N'Duyen Ngo Thi Cam', N'duyenngo1234', N'Duyenngo@2k2', N'Soc Trang', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', NULL, 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10018, N'Duyen Ngo Thi Cam', N'duyenngo321', N'Admin@123', N'Soc Trang', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', NULL, 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10019, N'Duyen Ngo Thi Cam', N'duyenngo54321', N'Admin@123', N'Soc Trang', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', NULL, 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10020, N'Duyen Ngo Thi Cam', N'customer123', N'Admin@123', N'Soc Trang', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', NULL, 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10021, N'Duyen Ngo Thi Cam', N'customer12345', N'Admin@123', N'Soc Trang', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', NULL, 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10022, N'Duyen Ngo Thi Cam', N'customer1234567', N'Admin@123', N'Soc Trang', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', NULL, 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10023, N'Duyen Ngo Thi Cam', N'ngoduyen12345', N'Admin@123', N'Soc Trang', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', NULL, 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10024, N'Duyen Ngo Thi Cam', N'ngoduyen123456', N'Admin@123', N'Soc Trang', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', NULL, 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10025, N'Duyen Ngo Thi Cam', N'ngoduyen1234567', N'Admin@123', N'Soc Trang', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', NULL, 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10026, N'Ngo Duyen', N'username123', N'Admin@123', N'Soc Trang', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', NULL, 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10027, N'Ngo Duyen', N'username1234', N'Admin@123', N'Soc Trang', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', NULL, 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10028, N'Duyen Ngo Thi Cam', N'ntcduyen123', N'Admin@123', N'Ninh Kieu, Can Tho', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1682647293/eqbnznu3l3adioux2qce.jpg', 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10029, N'Duyen Ngo Thi Cam', N'user123', N'Admin@123', N'My Tu, Soc Trang', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1682647360/cwcqsghu4gaxva2jrghs.jpg', 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10032, N'Duyen Ngo Thi Cam', N'shizuka123', N'Shizuka@123', N'Ninh Kieu, Can Tho', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', NULL, 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10035, N'Duyen Ngo Thi Cam', N'blabla123', N'Admin@123', N'Ninh Kieu, Can Tho', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', NULL, 1)
INSERT [dbo].[Customers] ([CustomerID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Avatar], [Status]) VALUES (10037, N'Duyen Ngo Thi Cam', N'customer234', N'Admin@123', N'Ninh Kieu, Can Tho', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1682647465/qfnmwbdumio84msgcwh6.webp', 1)
SET IDENTITY_INSERT [dbo].[Customers] OFF
GO
SET IDENTITY_INSERT [dbo].[Employees] ON 

INSERT [dbo].[Employees] ([EmployeeID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Status]) VALUES (1090, N'Ngo Thi Cam Duyen', N'duyenngo', N'duyenngo', N'Mau Than, Ninh Kieu, Can Tho', N'0387090621', N'ntcduyen2903@gmail.com', 1)
INSERT [dbo].[Employees] ([EmployeeID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Status]) VALUES (1091, N'Ngo Thi Cam Duyen', N'ngocamduyen', N'employee', N'Ninh Kieu, Can Tho', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', 1)
INSERT [dbo].[Employees] ([EmployeeID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Status]) VALUES (1092, N'Ngo Thi Cam Duyen', N'ngothicamduyen', N'employee', N'Ninh Kieu, Can Tho', N'0387090621', N'ntcduyena20173@cusc.ctu.edu.vn', 1)
INSERT [dbo].[Employees] ([EmployeeID], [Fullname], [Username], [Password], [Address], [PhoneNumber], [Email], [Status]) VALUES (1097, N'Ngo Thi Cam Duyen', N'ngothicamduyen123', N'ngothicamduyen', N'60/29 Mau Than, Ninh Kieu, Can Tho', N'0387090621', N'ngothicamduyen2002@gmail.com', 1)
SET IDENTITY_INSERT [dbo].[Employees] OFF
GO
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10012, 10060, N'This my product so cool and i can see it everywhere because i am dealer', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10040, 10060, N'Very luxury!', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10041, 10060, N'Item is as beautiful as the picture, just for the purpose of receiving coins', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10042, 10057, N'Good product, fast delivery!', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10043, 10072, N'Product is very luxury!', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10044, 10057, N'Very nice cabinet, a little worn. But it is okay!', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10045, 10057, N'Product same as picture! Will support next time', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10046, 10057, N'Item must be beautiful, but there was a time when the delivery was chipped in one corner, and the handle was also chipped', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10047, 10057, N'Good product quality, reasonable price, fast delivery, good service, good packaging, will definitely continue to support the shop', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10048, 10057, N'The product is beautiful, sturdy, no scratches, good packaging, but there is a delivery that takes a while, but that is okay, still acceptable, give 5 stars!', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10049, 10057, N'The product is beautiful!', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10050, 10057, N'The cabinet is just right, not as big as in the picture...easy to install, can be installed alone, can hold fine items. Sit down. Satisfied within reach', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10051, 10057, N'Product quality is good
Good material
True to the description
Easy to install', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10052, 10057, N'Packaged carefully. Good wood. The joints are slightly off. Can be self-corrected. Shop support.', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10053, 10058, N'The product is beautiful, very satisfied, the price is very cheap, the shop delivers enough. Everyone support the shop', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10054, 10063, N'Super fast delivery! Easy assembly', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10055, 10057, N'Item is as beautiful as the picture, just for the purpose of receiving coins', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10056, 10071, N'Item is as beautiful as the picture!', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10057, 10057, N'Can be used. But 1 bolt broke during shipping, so the 2nd one was a bit loose when installing', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10058, 10072, N'Ok, suitable for the price, in general, it is convenient and economical, but still preserves the shoes, a little difficult to assemble, but it is still ok for such a cheap price!', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10059, 10072, N'Ok, suitable for the price, in general, it is convenient and economical, but still preserves the shoes, a little difficult to assemble, but it is still ok for such a cheap price!', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10060, 10061, N'Ok, suitable for the price, in general, it is convenient and economical, but still preserves the shoes, a little difficult to assemble, but it is still ok for such a cheap price.', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10061, 10061, N'Very beautifulll!', N'5')
INSERT [dbo].[FeedbackDetails] ([FeedbackID], [ProductID], [FeedbackContent], [Reviews]) VALUES (10062, 10057, N'Test', N'5')
GO
SET IDENTITY_INSERT [dbo].[Feedbacks] ON 

INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10012, CAST(N'2023-04-23T00:00:00.000' AS DateTime), 10000, 1)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10040, CAST(N'2023-04-23T00:00:00.000' AS DateTime), 10037, 1)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10041, CAST(N'2023-04-23T00:00:00.000' AS DateTime), 10037, 1)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10042, CAST(N'2023-04-27T00:00:00.000' AS DateTime), 10037, 1)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10043, CAST(N'2023-04-27T00:00:00.000' AS DateTime), 10037, 1)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10044, CAST(N'2023-04-27T00:00:00.000' AS DateTime), 10000, 1)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10045, CAST(N'2023-04-27T00:00:00.000' AS DateTime), 10000, 1)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10046, CAST(N'2023-04-27T00:00:00.000' AS DateTime), 10000, 1)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10047, CAST(N'2023-04-27T00:00:00.000' AS DateTime), 10000, 1)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10048, CAST(N'2023-04-27T00:00:00.000' AS DateTime), 10000, 1)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10049, CAST(N'2023-04-27T00:00:00.000' AS DateTime), 10000, 1)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10050, CAST(N'2023-04-27T00:00:00.000' AS DateTime), 10000, 0)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10051, CAST(N'2023-04-27T00:00:00.000' AS DateTime), 10000, 1)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10052, CAST(N'2023-04-27T00:00:00.000' AS DateTime), 10000, 1)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10053, CAST(N'2023-04-27T00:00:00.000' AS DateTime), 10000, 1)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10054, CAST(N'2023-04-28T00:00:00.000' AS DateTime), 10005, 1)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10055, CAST(N'2023-04-28T00:00:00.000' AS DateTime), 10029, 0)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10056, CAST(N'2023-04-28T00:00:00.000' AS DateTime), 10029, 0)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10057, CAST(N'2023-04-28T00:00:00.000' AS DateTime), 10000, 0)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10058, CAST(N'2023-04-28T00:00:00.000' AS DateTime), 10000, 0)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10059, CAST(N'2023-04-28T00:00:00.000' AS DateTime), 10000, 0)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10060, CAST(N'2023-04-28T00:00:00.000' AS DateTime), 10000, 0)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10061, CAST(N'2023-04-28T00:00:00.000' AS DateTime), 10000, 0)
INSERT [dbo].[Feedbacks] ([FeedbackID], [CreationDate], [CustomerID], [Status]) VALUES (10062, CAST(N'2023-04-28T00:00:00.000' AS DateTime), 10000, 0)
SET IDENTITY_INSERT [dbo].[Feedbacks] OFF
GO
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (10056, 10058, 1, 344.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (10058, 10071, 1, 130.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (10059, 10061, 1, 409.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (10059, 10062, 1, 545.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (10060, 10057, 1, 208.2600)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (10061, 10057, 2, 208.2600)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (10061, 10060, 3, 669.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (10061, 10071, 1, 130.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (10061, 10078, 1, 21.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (10061, 10080, 1, 42.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (10062, 10071, 3, 130.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (10062, 10081, 1, 98.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (10063, 10061, 2, 409.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (10063, 10071, 1, 130.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (10063, 10073, 1, 211.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (10064, 10058, 2, 344.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (10064, 10060, 1, 669.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (11064, 10057, 1, 234.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (11064, 10063, 1, 719.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (11065, 10062, 4, 545.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (11066, 10069, 1, 23.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (11067, 10075, 3, 21.0000)
INSERT [dbo].[OrderDetails] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (11068, 10079, 1, 44.0000)
GO
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([OrderID], [CustomerID], [EmployeeID], [OrderDate], [TotalAmount], [TotalPrice], [PaymentMethod], [Note], [Status]) VALUES (10056, 10000, 1090, CAST(N'2023-04-19T00:00:00.000' AS DateTime), 1, 344.0000, N'Cash', NULL, 1)
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [EmployeeID], [OrderDate], [TotalAmount], [TotalPrice], [PaymentMethod], [Note], [Status]) VALUES (10058, 10000, 1090, CAST(N'2023-04-19T00:00:00.000' AS DateTime), 1, 130.0000, N'Cash', NULL, 1)
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [EmployeeID], [OrderDate], [TotalAmount], [TotalPrice], [PaymentMethod], [Note], [Status]) VALUES (10059, 10000, 1090, CAST(N'2023-04-19T00:00:00.000' AS DateTime), 2, 954.0000, N'Cash', NULL, 3)
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [EmployeeID], [OrderDate], [TotalAmount], [TotalPrice], [PaymentMethod], [Note], [Status]) VALUES (10060, 10000, 1090, CAST(N'2023-04-20T00:00:00.000' AS DateTime), 1, 208.2600, N'Cash', NULL, 0)
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [EmployeeID], [OrderDate], [TotalAmount], [TotalPrice], [PaymentMethod], [Note], [Status]) VALUES (10061, 10000, 1090, CAST(N'2023-04-21T00:00:00.000' AS DateTime), 6, 2640.5200, N'Cash', NULL, 0)
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [EmployeeID], [OrderDate], [TotalAmount], [TotalPrice], [PaymentMethod], [Note], [Status]) VALUES (10062, 10000, 1090, CAST(N'2023-04-21T00:00:00.000' AS DateTime), 2, 488.0000, N'Cash', NULL, 0)
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [EmployeeID], [OrderDate], [TotalAmount], [TotalPrice], [PaymentMethod], [Note], [Status]) VALUES (10063, 10000, 1090, CAST(N'2023-04-22T00:00:00.000' AS DateTime), 3, 1159.0000, N'Cash', NULL, 0)
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [EmployeeID], [OrderDate], [TotalAmount], [TotalPrice], [PaymentMethod], [Note], [Status]) VALUES (10064, 10000, 1090, CAST(N'2023-04-25T00:00:00.000' AS DateTime), 2, 1357.0000, N'Cash', NULL, 0)
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [EmployeeID], [OrderDate], [TotalAmount], [TotalPrice], [PaymentMethod], [Note], [Status]) VALUES (11064, 10000, 1090, CAST(N'2023-04-27T00:00:00.000' AS DateTime), 2, 953.0000, N'Cash', NULL, 0)
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [EmployeeID], [OrderDate], [TotalAmount], [TotalPrice], [PaymentMethod], [Note], [Status]) VALUES (11065, 10005, 1090, CAST(N'2023-04-28T00:00:00.000' AS DateTime), 1, 2180.0000, N'Cash', NULL, 0)
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [EmployeeID], [OrderDate], [TotalAmount], [TotalPrice], [PaymentMethod], [Note], [Status]) VALUES (11066, 10015, 1090, CAST(N'2023-04-28T00:00:00.000' AS DateTime), 1, 23.0000, N'Cash', NULL, 0)
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [EmployeeID], [OrderDate], [TotalAmount], [TotalPrice], [PaymentMethod], [Note], [Status]) VALUES (11067, 10037, 1090, CAST(N'2023-04-28T00:00:00.000' AS DateTime), 1, 63.0000, N'Cash', NULL, 0)
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [EmployeeID], [OrderDate], [TotalAmount], [TotalPrice], [PaymentMethod], [Note], [Status]) VALUES (11068, 10032, 1090, CAST(N'2023-04-28T00:00:00.000' AS DateTime), 1, 44.0000, N'Cash', NULL, 0)
SET IDENTITY_INSERT [dbo].[Orders] OFF
GO
INSERT [dbo].[Owner] ([Username], [Password], [Email]) VALUES (N'owner', N'admin', N'owner@gmail.com')
GO
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10057, N'Piece Upholstered Sectional', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1000, 102, 104, 234.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681876814/gkrijrjtknith0dsea62.png', 46, 0, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10058, N'Piece Upholstered Sectional', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1000, 103, 104, 344.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681876846/i9te8stfxr4aant2sqvh.png', 7, 0, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10059, N'Wide Outdoor Wicker Patio Sofa', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1001, 105, 105, 859.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681876920/u40ttjcqlicvakryuose.jpg', 5, 1, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10060, N'Wide Outdoor Patio Daybed with Cushions', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1001, 104, 112, 669.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681876968/cxetoymwo0x86yuxtm9o.png', 46, 0, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10061, N'Wide Outdoor Patio Daybed with Cushions', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1001, 106, 104, 409.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681877059/vi6oj9vvdzkfaqagtpm3.png', 97, 0, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10062, N'Wide Outdoor Wicker Symmetrical', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1001, 100, 104, 545.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681877105/hmkx64f72jnsa1shf30f.png', 5, 0, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10063, N'Wide Outdoor Loveseat with Cushions', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1001, 104, 104, 719.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681877159/mkjg0xkytv4koxdmcknd.jpg', 49, 0, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10069, N'Dhurrie Cotton Percale Quilt Set', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1005, 104, 104, 23.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681877933/awrvk6gf0xrcmokioq4s.webp', 99, 0, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10070, N'Cotton Percale Quilt Set Caro', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1005, 105, 112, 32.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681877968/opxgvth56xyyzt9knrnp.jpg', 500, 1, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10071, N'Pyron Handmade Ceramic Table Vase', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1004, 103, 104, 130.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681878114/tcw4vnm6ouseoeklquic.jpg', 394, 0, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10072, N'3 Piece Wood Tabletop Candlestick Set', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1004, 104, 104, 139.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681878165/wncfmnlghkrftiivotf3.webp', 300, 0, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10073, N'Ceramic Floor Vase Color', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1004, 102, 104, 211.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681878222/z3rvviyjris1xhcgvrtb.jpg', 199, 0, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10074, N'Ceramic Floor Vase Person', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1004, 100, 102, 49.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681878261/lcsyzry0zs75qqs3jept.png', 200, 0, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10075, N'Xavier Bird Figurine ', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1004, 103, 105, 21.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681878325/hgcywj3kloeyijrpbsa3.webp', 597, 0, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10078, N'Alameda 3 Piece Tiered Shelf with Towel Bar Brown Color', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1017, 103, 104, 21.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681878632/tohice0rnuc8a9z9qlvn.jpg', 199, 0, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10079, N'Rustic Floating Shelves Rabbit Green', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1017, 102, 104, 44.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681878721/tzf6y4pdqhgjbxocy0zn.webp', 299, 0, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10080, N'Rustic Floating Shelves Red Color', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1017, 102, 102, 42.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681878750/csfjlztiddobgq4urs1p.jpg', 299, 0, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10081, N'Ceiling Fan with LED Lights ', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1006, 102, 104, 98.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681878929/jkt8kriglvbm6pny4hmh.png', 499, 0, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [Description], [CategoryID], [SupplierID], [BrandID], [UnitPrice], [Image], [Quantity], [PromotionStatus], [Status]) VALUES (10082, N'Ceiling Fan with LED Lights Flower', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.', 1006, 106, 105, 99.0000, N'https://res.cloudinary.com/dh5kp6ex1/image/upload/v1681878999/oabsyvx8jjhy5xjgsz7t.png', 200, 1, 0)
SET IDENTITY_INSERT [dbo].[Products] OFF
GO
SET IDENTITY_INSERT [dbo].[Promotions] ON 

INSERT [dbo].[Promotions] ([PromotionID], [ProductID], [PromotionName], [PromotionDate], [Discount], [AmountApplyPromotion], [Note], [DateEnd]) VALUES (1175, 10079, N'30/4 - 1/5', CAST(N'2023-04-30' AS Date), 14, 38.0000, N'Super sale', CAST(N'2023-04-30' AS Date))
INSERT [dbo].[Promotions] ([PromotionID], [ProductID], [PromotionName], [PromotionDate], [Discount], [AmountApplyPromotion], [Note], [DateEnd]) VALUES (1176, 10070, N'30/4 - 1/5', CAST(N'2023-04-30' AS Date), 21, 26.0000, N'Super sale', CAST(N'2023-04-30' AS Date))
INSERT [dbo].[Promotions] ([PromotionID], [ProductID], [PromotionName], [PromotionDate], [Discount], [AmountApplyPromotion], [Note], [DateEnd]) VALUES (1177, 10059, N'30/4 - 1/5', CAST(N'2023-04-30' AS Date), 22, 671.0000, N'Super sale', CAST(N'2023-04-30' AS Date))
INSERT [dbo].[Promotions] ([PromotionID], [ProductID], [PromotionName], [PromotionDate], [Discount], [AmountApplyPromotion], [Note], [DateEnd]) VALUES (1179, 10082, N'30/4 - 1/5', CAST(N'2023-04-29' AS Date), 22, 78.0000, N'Super sale', CAST(N'2023-05-02' AS Date))
SET IDENTITY_INSERT [dbo].[Promotions] OFF
GO
SET IDENTITY_INSERT [dbo].[Suppliers] ON 

INSERT [dbo].[Suppliers] ([SupplierID], [CompanyName], [PhoneNumber], [Address], [Email], [Website], [Status]) VALUES (100, N'Sendecor', N'0387090621', N'Ninh Kieu, Can Tho', N'sendecor@gmail.com', N'sendecor.vn', 0)
INSERT [dbo].[Suppliers] ([SupplierID], [CompanyName], [PhoneNumber], [Address], [Email], [Website], [Status]) VALUES (102, N'Wayfair', N'0387090621', N'Ninh Kieu, Can Tho', N'Wayfair@gmail.com', N'wayfair.com.vn', 0)
INSERT [dbo].[Suppliers] ([SupplierID], [CompanyName], [PhoneNumber], [Address], [Email], [Website], [Status]) VALUES (103, N'Williams', N'0387090621', N'Ninh Kieu, Can Tho', N'williams@gmail.com', N'williams.com.vn', 0)
INSERT [dbo].[Suppliers] ([SupplierID], [CompanyName], [PhoneNumber], [Address], [Email], [Website], [Status]) VALUES (104, N'Sonoma', N'0387090621', N'Ninh Kieu, Can Tho', N'Sonoma@gmail.com', N'sonoma .com.vn', 0)
INSERT [dbo].[Suppliers] ([SupplierID], [CompanyName], [PhoneNumber], [Address], [Email], [Website], [Status]) VALUES (105, N'Yao', N'0387090621', N'Ninh Kieu, Can Tho', N'yao@gmail.com', N'yao.vn', 0)
INSERT [dbo].[Suppliers] ([SupplierID], [CompanyName], [PhoneNumber], [Address], [Email], [Website], [Status]) VALUES (106, N'Megaman', N'0387090621', N'Ninh Kieu, Can Tho', N'megaman@gmail.com', N'megaman.com.vn', 0)
SET IDENTITY_INSERT [dbo].[Suppliers] OFF
GO
ALTER TABLE [dbo].[FeedbackDetails]  WITH CHECK ADD FOREIGN KEY([FeedbackID])
REFERENCES [dbo].[Feedbacks] ([FeedbackID])
GO
ALTER TABLE [dbo].[FeedbackDetails]  WITH CHECK ADD FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ProductID])
GO
ALTER TABLE [dbo].[Feedbacks]  WITH CHECK ADD  CONSTRAINT [FK_feedbackcustomer] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Customers] ([CustomerID])
GO
ALTER TABLE [dbo].[Feedbacks] CHECK CONSTRAINT [FK_feedbackcustomer]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD FOREIGN KEY([OrderID])
REFERENCES [dbo].[Orders] ([OrderID])
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ProductID])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Customers] ([CustomerID])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([EmployeeID])
REFERENCES [dbo].[Employees] ([EmployeeID])
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD FOREIGN KEY([BrandID])
REFERENCES [dbo].[Brands] ([BrandID])
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD FOREIGN KEY([CategoryID])
REFERENCES [dbo].[Categories] ([CategoryID])
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD FOREIGN KEY([SupplierID])
REFERENCES [dbo].[Suppliers] ([SupplierID])
GO
ALTER TABLE [dbo].[Promotions]  WITH CHECK ADD FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ProductID])
GO
USE [master]
GO
ALTER DATABASE [CP2296H01_G4_KAYA] SET  READ_WRITE 
GO
