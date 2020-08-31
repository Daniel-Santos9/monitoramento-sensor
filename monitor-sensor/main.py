
import json
from firebase import firebase


from random import randint
import time

sensor_temp = 0
sensor_lumi = 0

while True:
    temp = randint(20,37)
    lum = randint(20,37)
    t = str(temp)
    l = str(lum)

    json_data = {'nome': 'sensor de temperatura', 'tipo_saida': 'digital', 'range': "10", 'velocidade_resposta': "1", 'unidade_medida': 'Celsius', 'localizacao':'100,632', 'status': 'ON', 'medida': t}
    json_data2 = {'nome': 'sensor_luminosidade', 'saida_saida': 'digital', 'range': "10", 'velocidade_resposta': "1", 'unidade_medida': 'Lumis', 'localizacao':'100,632', 'status': 'ON', 'medida': l}


    json_data = json.dumps(json_data, indent=8, sort_keys=True)
    json_data2 = json.dumps(json_data2, indent=8,sort_keys=True)

    parsed_json = (json.loads(json_data))
    parsed_json2 = (json.loads(json_data2))

    print(json_data)

    if sensor_temp == 0:
        firebase = firebase.FirebaseApplication("https://monitoramento-sensor.firebaseio.com", authentication=None)
        #res = firebase.get("/sensor", None)
        res = firebase.post('/sensor', parsed_json)
        res2 = firebase.post('/sensor', parsed_json2)
        print(res)
        print(res2)
    else:
        firebase.put('/sensor', res['name'], parsed_json)
        firebase.put('/sensor', res2['name'], parsed_json2)


    time.sleep(2)
    sensor_temp +=1
    sensor_lumi +=1

