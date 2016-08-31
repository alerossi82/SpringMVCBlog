USE [BLOG]
GO
/****** Object:  Table [dbo].[Voto]    Script Date: 31-Aug-16 10:41:31 PM ******/
DROP TABLE [dbo].[Voto]
GO
/****** Object:  Table [dbo].[Voto]    Script Date: 31-Aug-16 10:41:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Voto](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Nome] [int] NULL
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Voto] ON 

INSERT [dbo].[Voto] ([ID], [Nome]) VALUES (1, 1)
INSERT [dbo].[Voto] ([ID], [Nome]) VALUES (2, 2)
INSERT [dbo].[Voto] ([ID], [Nome]) VALUES (3, 3)
INSERT [dbo].[Voto] ([ID], [Nome]) VALUES (4, 4)
INSERT [dbo].[Voto] ([ID], [Nome]) VALUES (5, 5)
SET IDENTITY_INSERT [dbo].[Voto] OFF
