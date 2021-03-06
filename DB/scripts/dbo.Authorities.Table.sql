USE [BLOG]
GO
ALTER TABLE [dbo].[Authorities] DROP CONSTRAINT [fk_authorities_users]
GO
/****** Object:  Index [ix_auth_username]    Script Date: 21-Jan-17 7:03:21 PM ******/
ALTER TABLE [dbo].[Authorities] DROP CONSTRAINT [ix_auth_username]
GO
/****** Object:  Table [dbo].[Authorities]    Script Date: 21-Jan-17 7:03:21 PM ******/
DROP TABLE [dbo].[Authorities]
GO
/****** Object:  Table [dbo].[Authorities]    Script Date: 21-Jan-17 7:03:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Authorities](
	[username] [varchar](50) NOT NULL,
	[authority] [varchar](50) NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Authorities] ([username], [authority]) VALUES (N'Alessandro', N'ROLE_ADMIN')
INSERT [dbo].[Authorities] ([username], [authority]) VALUES (N'Fabio', N'ROLE_ADMIN')
INSERT [dbo].[Authorities] ([username], [authority]) VALUES (N'Julie', N'ROLE_USER')
SET ANSI_PADDING ON

GO
/****** Object:  Index [ix_auth_username]    Script Date: 21-Jan-17 7:03:21 PM ******/
ALTER TABLE [dbo].[Authorities] ADD  CONSTRAINT [ix_auth_username] UNIQUE NONCLUSTERED 
(
	[username] ASC,
	[authority] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Authorities]  WITH CHECK ADD  CONSTRAINT [fk_authorities_users] FOREIGN KEY([username])
REFERENCES [dbo].[Users] ([username])
GO
ALTER TABLE [dbo].[Authorities] CHECK CONSTRAINT [fk_authorities_users]
GO
