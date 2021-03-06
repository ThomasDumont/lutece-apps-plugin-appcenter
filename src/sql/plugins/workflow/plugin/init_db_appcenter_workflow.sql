INSERT INTO workflow_workflow VALUES 
(100,'Workflow des demandes de configuration d\'un référentiel','Workflow des demandes de configuration d\'un référentiel','2017-08-16 12:38:32',1,'all'),
(200,'Workflow des demandes d\'agents OpenAM','Workflow des demandes d\'agents OpenAM','2017-08-16 12:38:32',1,'all'),
(300,'Workflow des demandes d\'ajout de liens MonCompte','Workflow des demandes d\'ajout de liens MonCompte','2017-08-16 12:38:32',1,'all'),
(400,'Workflow des demandes de paramétrages NotifyGRU','Workflow des demandes de paramétrages NotifyGRU','2017-08-16 12:38:32',1,'all'),
(500,'Workflow des demandes de configuration IdentityStore','Workflow des demandes de paramétrages IdentityStore','2017-08-16 12:38:32',1,'all'),
(600,'Workflow des demandes d\'ajout d\'application FastDeploy','Workflow des demandes d\'ajout d\'application FastDeploy','2017-08-16 12:38:32',1,'all'),
(700,'Workflow des demandes d''intégration continue','Workflow des demandes d''intégration continue','2017-11-07 12:38:32',1,'all'),
(800,'Workflow des demandes de configuration de la notification vers le guichet pro','Workflow des demandes de configuration de la notification vers le guichet pro','2017-11-07 12:38:32',1,'all'),
(900,'Workflow des demandes de code applicatif','Workflow des demandes de code applicatif','2017-11-07 12:38:32',1,'all'),
(1000,'Workflow des demandes de support applicatif','Workflow des demandes de support applicatif','2017-11-07 12:38:32',1,'all');


INSERT INTO workflow_state VALUES 
(100,'Initialisée','Demande initialisée',100,1,0,NULL,1),
(101,'En cours','Demande en cours',100,0,0,NULL,2),
(102,'Close','Demande close',100,0,0,NULL,3),

(200,'Initialisée','Demande initialisée',200,1,0,NULL,1),
(201,'En cours','Demande en cours',200,0,0,NULL,2),
(202,'Close','Demande close',200,0,0,NULL,3),

(300,'Initialisée','Demande initialisée',300,1,0,NULL,1),
(301,'En cours','Demande en cours',300,0,0,NULL,2),
(302,'Close','Demande close',300,0,0,NULL,3),

(400,'Initialisée','Demande initialisée',400,1,0,NULL,1),
(401,'En cours','Demande en cours',400,0,0,NULL,2),
(402,'Close','Demande close',400,0,0,NULL,3),

(500,'Initialisée','Demande initialisée',500,1,0,NULL,1),
(501,'En cours','Demande en cours',500,0,0,NULL,2),
(502,'Close','Demande close',500,0,0,NULL,3),

(600,'Initialisée','Demande initialisée',600,1,0,NULL,1),
(601,'En cours','Demande en cours',600,0,0,NULL,2),
(602,'Close','Demande close',600,0,0,NULL,3),

(700,'Initialisée','Demande initialisée',700,1,0,NULL,1),
(701,'En cours','Demande en cours',700,0,0,NULL,2),
(702,'Close','Demande close',700,0,0,NULL,3),

(800,'Initialisée','Demande initialisée',800,1,0,NULL,1),
(801,'En cours','Demande en cours',800,0,0,NULL,2),
(802,'Close','Demande close',800,0,0,NULL,3),

(900,'Initialisée','Demande initialisée',900,1,0,NULL,1),
(901,'En cours','Demande en cours',900,0,0,NULL,2),
(902,'Close','Demande close',900,0,0,NULL,3),

(1000,'Initialisée','Demande initialisée',1000,1,0,NULL,1),
(1001,'En cours','Demande en cours',1000,0,0,NULL,2),
(1002,'Close','Demande close',1000,0,0,NULL,3);

INSERT INTO workflow_action VALUES 
(100,'Creation de la demande de configuration d\'un référentiel','Creation de la demande de configuration d\'un référentiel',100,100,101,3,1,0,1,0),
(200,'Creation de la demande de configuration de l\'authentification front office','Creation de la demande de configuration de l\'authentification front office',200,200,201,3,1,0,1,0),
(300,'Creation de la demande d\'ajout de liens MonCompte','Creation de la demande d\'ajouts de liens MonCompte',300,300,301,3,1,0,1,0),
(400,'Creation de la demande de paramétrage NotifyGRU','Creation de la demande de paramétrage NotifyGRU',400,400,401,3,1,0,1,0),
(500,'Creation de la demande de paramétrage Identitystore','Creation de la demande de paramétrage Identitystore',500,500,501,3,1,0,1,0),
(600,'Creation de la demande d\'application FastDeploy','Creation de la demande d\'application FastDeploy',600,600,601,3,1,0,1,0),
(700,'Creation de la demande d''intégration continue','Creation de la demande d''intégration continue',700,700,701,3,1,0,1,0),
(800,'Creation de la demande de configuration de la notification vers le guichet profesionnel','Creation de la demande de configuration de la notification vers le guichet professionnel',800,800,801,3,1,0,1,0),
(900,'Creation de la demande de code applicatif','Creation de la demande de code applicatif',900,900,901,3,1,0,1,0),
(1000,'Creation de la demande de support applicatif','Creation de la demande de support applicatif',1000,1000,1001,3,1,0,1,0),

(101,'Traiter la demande de configuration d\'un référentiel','Traiter la demande de configuration d\'un réfrérentiel',100,101,102,3,0,0,2,0),
(201,'Traiter la demande de configuration de l\'authentification front office','Traiter la demande de configuration de l\'authentification front office',200,201,202,3,0,0,2,0),
(301,'Traiter la demande d\'ajout de liens MonCompte','Traiter la demande d\'ajout de liens MonCompte',300,301,302,3,0,0,2,0),
(401,'Traiter la demande de paramétrage NotifyGRU','Traiter la demande de paramétrage NotifyGRU',400,401,402,3,0,0,2,0),
(501,'Traiter la demande de paramétrage IdentityStore','Traiter la demande de paramétrage IdentityStore',500,501,502,3,0,0,2,0),
(601,'Traiter la demande de creation d\'une application FastDeploy','Traiter la demande de creation d\'une application FastDeploy',600,601,602,3,0,0,2,0),
(701,'Traiter la demande de paramétrage d\'intégration continue','Traiter la demande de paramétrage d''intégration continue',700,701,702,3,0,0,2,0),
(801,'Traiter la demande de configuration de la notification vers le guichet professionnel','Traiter la demande de configuration de la notification vers le guichet professionnel',800,801,802,3,0,0,2,0),
(901,'Traiter la demande de code applicatif','Traiter la demande de code applicatif',900,901,902,3,0,0,2,0),
(1001,'Traiter la demande de support applicatif','Traiter la demande de support applicatif',1000,1001,1002,3,0,0,2,0);


INSERT INTO workflow_task VALUES
(1,'taskCustomDemandStatus',100,2),
(2,'taskSources',101,1),
(3,'taskCustomDemandStatus',101,2),
(4,'taskCloseDemand',101,3),
(5,'taskCustomDemandStatus',200,2),
(6,'taskOpenam',201,1),
(7,'taskCustomDemandStatus',201,2),
(8,'taskCloseDemand',201,3),
(9,'taskCustomDemandStatus',300,2),
(10,'taskMonCompteSettings',301,1),
(11,'taskCustomDemandStatus',301,2),
(12,'taskCloseDemand',301,3),
(13,'taskCustomDemandStatus',400,2),
(14,'taskNotificationGru',401,1),
(15,'taskCustomDemandStatus',401,2),
(16,'taskCloseDemand',401,3),
(17,'taskCustomDemandStatus',500,1),
(18,'taskIdentitystore',501,1),
(19,'taskCustomDemandStatus',501,2),
(20,'taskCloseDemand',501,3),
(21,'taskCustomDemandStatus',600,1),
(22,'taskFastDeployApplication',601,1),
(23,'taskCustomDemandStatus',601,2),
(24,'taskCloseDemand',601,3),
(25,'taskCustomDemandStatus', 700, 1),
(26,'taskJob', 701, 1),
(27,'taskCustomDemandStatus', 701, 2),
(28,'taskCloseDemand',701,3),
(29,'taskCustomDemandStatus',800,2),
(30,'taskGuichetPro',801,1),
(31,'taskCustomDemandStatus',801,2),
(32,'taskCloseDemand',801,3),
(33,'taskCustomDemandStatus',900,2),
(34,'taskAppCode',901,1),
(35,'taskCustomDemandStatus',901,2),
(36,'taskCloseDemand',901,3),
(37,'taskCustomDemandStatus',1000,2),
(38,'taskSupport',1001,1),
(39,'taskCustomDemandStatus',1001,2),
(40,'taskCloseDemand',1001,3);




INSERT INTO appcenter_task_custom_demand_status_config VALUES
(1,'Demande de configuration d\'un référentiel'),
(3,'La demande de configuration d\'un référentiel a été traité'),
(5,'Demande de configuration de l\'authentification front office en cours de traitement'),
(7,'La demande de configuration de l\'authentification front office a été traitée'),
(9,'Demande d\'ajout de liens MonCompte en cours de traitement'),
(11,'La demande d\'ajout de liens MonCompte a été traitée'),
(13,'Demande de configuration de la notification GRU en cours de traitement'),
(15,'La configuration de la notification GRU a été effecuée'),
(17,'La demande de configuration de votre application dans le référentiel d\'identité est en cours de traitement'),
(19,'La demande de configuration de votre application dans le référentiel d\'identité a bien été traitée'),
(21,'Demande d\' ajout d\'une application FastDeploy est en cours de traitement'),
(23,'La demande d\' ajout d\'une application FastDeploy a bein été traitée'),
(25, 'Demande de tâche d\'intégration continue en cours de traitement'),
(27, 'Les tâches d\'intégration continue ont été créées'),
(29,'La demande de configuration de la notification vers le guichet professionnel est en cours de traitement'),
(31,'La demande de configuration de la notification vers le guichet professionnel a bien été traitée'),
(33,'La demande de code applicatif est en cours de traitement'),
(35,'La demande de code applicatif a bien été traitée'),
(37,'La demande de support applicatif est en cours de traitement'),
(39,'La demande de support applicatif a bien été traitée');


INSERT INTO workflow_resource_workflow VALUES 
(1,'DEMANDCENTER_DEMAND_SOURCE',101,100,-1,0);
INSERT INTO workflow_resource_history VALUES 
(1,1,'DEMANDCENTER_DEMAND_SOURCE',100,100,'2017-08-17 12:24:13','auto');
