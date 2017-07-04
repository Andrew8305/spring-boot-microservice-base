# Central Service

以下の機能を提供する中央制御サービスです

* サービスディスカバリ (Eurekaサーバー)

> *その他必要な場合は順次記載予定*

<br/>

2017/6/23<br/>
**ここからは別サービスに移行するため無視してください**

<br/>


## バックエンドAPIへのアクセス方法

各マイクロサービスが他のサービスのAPIにアクセスする場合は、このサービスにアクセスします。

ローカル環境ではデフォルトで 5100 ポートで起動します。

バックエンドAPIは、以下のようなフォーマットでマッピングされます。

http://localhost:5100/api/[service-name]/[service-endpoint]


例） baseサービスのecho APIのパス

http://localhost:5100/api/base/v1/echo?message=test


## バックエンドAPI仕様書

各マイクロサービスはAPI仕様書を提供します。

http://localhost:5100/api/[service-name]/swagger-ui.html

例） baseサービスのAPI仕様書

http://localhost:5100/api/base/swagger-ui.html

