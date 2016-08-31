USE [BLOG]
GO
/****** Object:  Table [dbo].[Cucina]    Script Date: 31-Aug-16 10:41:31 PM ******/
DROP TABLE [dbo].[Cucina]
GO
/****** Object:  Table [dbo].[Cucina]    Script Date: 31-Aug-16 10:41:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cucina](
	[ID] [int] NULL,
	[Nome] [nvarchar](max) NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (1, N'Chinese')
INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (2, N'Czech')
INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (3, N'Greek')
INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (4, N'Indian')
INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (5, N'International')
INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (6, N'Italian')
INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (7, N'Mexican')
INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (8, N'Steakhouse')
INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (9, N'Sushi')
INSERT [dbo].[Cucina] ([ID], [Nome]) VALUES (10, N'Thai')
