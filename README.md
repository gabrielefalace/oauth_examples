# OAuth 2.0 Samples
examples of main OAuth 2.0 flows

## authserver 
A (so far) simple Authorization Server, mainly intended to be used with "client_credential" or "password" flows. It is equipped with a simple token store running on an embedded H2 database. 


While testing, remember to put this header: `Authorization` `Basic base64Encodeclient_id:client_secret)`
> e.g. Authorization Basic YWNtZTphY21lc2VjcmV0
> since base64Encode(acme:acmesecret) = YWNtZTphY21lc2VjcmV0
