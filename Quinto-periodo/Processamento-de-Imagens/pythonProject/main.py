import time
from pynput.keyboard import Controller, Key

# Inicializar o controlador de teclado
keyboard = Controller()

def press_key(key, press_time):
    """Pressiona e mantém a tecla pressionada por press_time segundos."""
    keyboard.press(key)
    time.sleep(press_time)
    keyboard.release(key)

def auto_press_key(main_key, interval, duration, secondary_key, secondary_press_time):
    """Pressiona a main_key a cada interval segundos por duration segundos.
       Durante o intervalo, mantém o secondary_key pressionado por secondary_press_time segundos."""
    end_time = time.time() + duration
    while time.time() < end_time:
        # Pressionar a tecla principal
        keyboard.press(main_key)
        keyboard.release(main_key)

        # Pressionar e manter a tecla secundária durante o intervalo
        interval_end_time = time.time() + interval
        while time.time() < interval_end_time:
            press_key(secondary_key, secondary_press_time)
            #press_key('f', 0.05)

#teste:
if __name__ == "__main__":
    main_key = 'z'  # Tecla principal a ser pressionada
    interval = 9  # Intervalo em segundos entre cada pressionamento da tecla principal
    duration = 25200  # Duração total em segundos para auto pressionar a tecla principal
    secondary_key = 'c'  # Tecla secundária a ser mantida pressionada
    secondary_press_time = 3  # Tempo em segundos para manter a tecla secundária pressionada

    # Exemplo de pressionar a tecla automaticamente
    auto_press_key(main_key, interval, duration, secondary_key, secondary_press_time)
#azcc