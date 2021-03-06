USE [BLOG]
GO
/****** Object:  Table [dbo].[Area]    Script Date: 21-Jan-17 7:03:21 PM ******/
DROP TABLE [dbo].[Area]
GO
/****** Object:  Table [dbo].[Area]    Script Date: 21-Jan-17 7:03:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Area](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Nome] [nvarchar](50) NOT NULL
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Area] ON 

INSERT [dbo].[Area] ([ID], [Nome]) VALUES (1, N'Prague 1')
INSERT [dbo].[Area] ([ID], [Nome]) VALUES (2, N'Prague 2')
INSERT [dbo].[Area] ([ID], [Nome]) VALUES (3, N'Prague 3')
INSERT [dbo].[Area] ([ID], [Nome]) VALUES (4, N'Prague 4')
INSERT [dbo].[Area] ([ID], [Nome]) VALUES (5, N'Prague 5')
INSERT [dbo].[Area] ([ID], [Nome]) VALUES (6, N'Prague 6')
INSERT [dbo].[Area] ([ID], [Nome]) VALUES (7, N'Prague 7')
INSERT [dbo].[Area] ([ID], [Nome]) VALUES (8, N'Prague 8')
INSERT [dbo].[Area] ([ID], [Nome]) VALUES (9, N'Prague 9')
INSERT [dbo].[Area] ([ID], [Nome]) VALUES (10, N'Prague 10')
SET IDENTITY_INSERT [dbo].[Area] OFF
