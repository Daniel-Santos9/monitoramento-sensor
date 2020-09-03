
import json
from firebase import firebase


from random import randint
import time

sensor_temp = 0
sensor_lumi = 0
temperatura = 0
luminosidade = 0
outros = 0
firebase = firebase.FirebaseApplication("https://monitoramento-sensor.firebaseio.com", authentication=None)

while 1:
    temp = randint(20,40)
    lum = randint(40,60)
    out = randint(100, 200)
    t = str(temp)
    l = str(lum)
    o = str(out)
    temperatura = 0
    outros = 0
    luminosidade =0

    res = firebase.get("/sensor", None)
    for i in res:
        #print("aaaa")
        for j in res.values():
            nomea = j["nome"]

            if(nomea.upper() == 'TEMPERATURA' or nomea.upper() == 'SENSOR DE TEMPERATURA'):
                #print(nomea.upper())
                if(temperatura == 0):
                    #print("aaaa")
                    local = '/sensor/'+str(i)
                    #print(local)
                    firebase.put(local, 'medida', t)
                    temperatura += 1
                    break
            elif(nomea.upper() == 'LUMINOSIDADE' or nomea.upper() == 'SENSOR DE LUMINOSIDADE'):
                #print(nomea.upper())
                if(luminosidade == 0):
                    #print("bbbb")
                    local = '/sensor/'+str(i)
                    #print(local)
                    firebase.put(local, 'medida', l)
                    luminosidade += 1
                    break
            else:
                if(outros == 0):
                    #print(nomea.upper())
                    #print("zzzzzzzzzzzzzzzzzzzzzzzzzzzz")
                    local = '/sensor/'+str(i)
                    #print(local)
                    firebase.put(local, 'medida', o)
                    outros += 1
                    break


    time.sleep(2)
    sensor_temp +=1
    sensor_lumi +=1

