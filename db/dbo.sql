/*
 Navicat Premium Data Transfer

 Source Server         : LAPTOP-QEPBRT42
 Source Server Type    : SQL Server
 Source Server Version : 15002080
 Source Catalog        : userdbtest
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 15002080
 File Encoding         : 65001

 Date: 13/03/2022 17:38:46
*/


-- ----------------------------
-- Table structure for usertable
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[usertable]') AND type IN ('U'))
	DROP TABLE [dbo].[usertable]
GO

CREATE TABLE [dbo].[usertable] (
  [id] nchar(10) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [username] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [password] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [email] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [gender] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [birthday] date  NULL
)
GO

ALTER TABLE [dbo].[usertable] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of usertable
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table usertable
-- ----------------------------
ALTER TABLE [dbo].[usertable] ADD CONSTRAINT [PK_usertable] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

