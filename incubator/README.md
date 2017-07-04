# Dr.JOY Incubator

これはDr.JOYの全サービスのソースコードを参照するプロジェクトです。アーキテクト担当者とデプロイ担当者だけがアクセスできます。

## ソースコードの取得

__NOTE: コマンドを実行するには、gitコマンドをインストールする必要があります。__

全サービスをクローンするコマンドを準備しています。
各々の環境に合わせてコマンドを実行してください。

* Macで実行する場合の例
```
$ ./clone-services_darwin_amd64
```

コマンド実行すると、incubatorディレクトリの同一階層にdrjoy-servicesディレクトリがされ、
drjoy-servicesディレクトリ配下に全サービスがクローンされます。

コマンド実行後は下記のようなディレクトリ構成になります。

```
.
├── drjoy-services
│   ├── service-calendar
│   ├── service-central
│   ├── service-chat
│   ├── service-config
│   ├── service-gateway
│   ├── service-group
│   ├── service-meeting
│   ├── service-mobile-front
│   ├── service-monitor
│   ├── service-registration
│   ├── service-web-front
│   ├── web-admin
│   ├── web-drjoy
│   └── web-prjoy
└── incubator
```

### クローンの確認

Intellij IDEAでincubatorを開き、全サービスが参照できていることを確認してください。
なお、webのサービスも同時にクローンしていますが、Intellij からは参照していません。
必要であれば、各サービスを別に開いてください。

## settings.xmlの修正

dr.joy固有のライブラリはs3で管理していて、アクセスキーの設定が必要になるため、下記の内容をmavenの[settings.xml](https://maven.apache.org/settings.html)に追加してください。

```
<server>
      <id>aws</id>
      <username>AKIAJS6UCDAHDVM2226A</username>
      <password>Szt8MiUlBL6lUjZVv9eQXEw0Wsfkdlr0tj2XKFSE</password>
</server>
```


## サービスの起動

サービスの起動は、下記の順でJava Applicationを実行してください。
なお、全サービスを起動するツールを作成予定です。作成するまでは手動で各サービスを実行してください。

1. drjoy-services/service-central/src/main/java/jp/drjoy/service/central/CentralApplication.java
1. drjoy-services/service-config/src/main/java/jp/drjoy/service/config/ConfigServerApplication.java
1. drjoy-services/service-monitor/src/main/java/jp/drjoy/service/monitor/ServiceMonitorApplication.java
1. drjoy-services/service-gateway/src/main/java/jp/drjoy/service/gateway/FrontGatewayApplication.java
1. drjoy-services/service-web-front/src/main/java/jp/drjoy/service/web/WebFrontApplication.java
1. drjoy-services/service-mobile-front/src/main/java/jp/drjoy/service/mobile/MobileFrontApplication.java
1. drjoy-services/service-group/src/main/java/jp/drjoy/service/group/GroupApplication.java
1. drjoy-services/service-registration/src/main/java/jp/drjoy/service/registration/RegistrationApplication.java
1. drjoy-services/service-chat/src/main/java/jp/drjoy/service/chat/ChatApplication.java
1. drjoy-services/service-meeting/src/main/java/jp/drjoy/service/meeting/MeetingApplication.java
1. drjoy-services/service-calendar/src/main/java/jp/drjoy/service/calendar/CalendarApplication.java
