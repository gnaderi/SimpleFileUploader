CREATE TABLE FileBag(id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  fileName VARCHAR(255) NOT NULL,
  contentType VARCHAR(255),
  fileSize INTEGER,
  creationDate TIMESTAMP,
  updatedDate TIMESTAMP,
  content BLOB);

INSERT INTO FileBag (fileName, contentType, fileSize, creationDate, updatedDate,content) VALUES ('File 1','String',26,null,null,NULL );
INSERT INTO FileBag (fileName, contentType, fileSize, creationDate, updatedDate,content) VALUES ('File 1','String',43,null,null,NULL );
