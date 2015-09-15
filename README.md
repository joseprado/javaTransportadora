# javaTransportadora

Foi desenvolvido um webservice Restfull que recebe os dados de:
 - Nome do Mapa
 - Origem
 - Destino
 - Autonomia do Caminhão
 - Valor do Combustivel

No seguinte formato:

localhost:8084/LevaETrazTransporte/mapa/calculo?nomeMapa={}&origem={}&destino={}&autonomia={}&precoCombust={}

Os dados serão exibitos em JSON

Para criação o webservice foi usado a biblioteca Jersey.
A persistencia dos dados foram feitos com JDBC e bando de dados Mysql.

Para obter os informações de rota e distancia entre os pontos, foi feita integração com a API da Google de Geolocalização
chamada Google Maps Directions API.
