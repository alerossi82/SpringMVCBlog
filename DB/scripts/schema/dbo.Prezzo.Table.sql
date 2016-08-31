USE [BLOG]
GO
/****** Object:  Table [dbo].[Prezzo]    Script Date: 31-Aug-16 10:41:31 PM ******/
DROP TABLE [dbo].[Prezzo]
GO
/****** Object:  Table [dbo].[Prezzo]    Script Date: 31-Aug-16 10:41:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Prezzo](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Nome] [nvarchar](50) NULL
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Prezzo] ON 

INSERT [dbo].[Prezzo] ([ID], [Nome]) VALUES (1, N'Cheap eats')
INSERT [dbo].[Prezzo] ([ID], [Nome]) VALUES (2, N'Mid-range')
INSERT [dbo].[Prezzo] ([ID], [Nome]) VALUES (3, N'Fine-dining')
SET IDENTITY_INSERT [dbo].[Prezzo] OFF
