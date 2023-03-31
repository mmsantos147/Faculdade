#Código em python para determinar qual magia, armas e status utilizar de forma aleatoria no jogo Elden Ring                                                                    
import random

armaesq = ["Adaga", "Espada", "Espada longa", "Espada Colossal", "Rapiera", "rapiera longa", "Espada curva", "Espada Curva Longa", "Katana", "Lamina gemea", 
"Machado", "Machado Grande", "Flail", "Martelo", "Martelo Grande", "Armas colossais", "Lança", "Lança grande", "Alabarda", "Foice", "Chicote", "Soqueira", "Garra", "Selo", "Cajado"]
armadir = ["Adaga", "Espada", "Espada longa", "Espada Colossal", "Rapiera", "rapiera longa", "Espada curva", "Espada Curva Longa", "Katana", "Lamina gemea", 
"Machado", "Machado Grande", "Flail", "Martelo", "Martelo Grande", "Armas colossais", "Lança", "Lança grande", "Alabarda", "Foice", "Chicote", "Soqueira", "Garra"]
status = ["Força", "Dex", "Intelecto", "Fé", "Arcano"]
magia = [ "Cariana/Loretta", "Gelo", "Morte", "Resto", "Gravidade", "Magma"]
encantamento = ["Bestial", "Sangue", "Dragão", "Erdtree", "Fogo", "Loucura", "Matador de deuses", "Ordem dourada", "Resto"]
x = random.choice(armaesq)
y = random.choice(armadir)

print(x)
print(y)
if x == "Selo":
    print(random.choice(encantamento))
elif x == "Cajado":
    print(random.choice(magia))
else:
    print(random.choice(status))