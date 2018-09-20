from PIL import Image
import math
import os

width_flag = 50
height_flag = 45
max_len = 20
images_path = str(os.path.dirname(os.path.abspath(__file__))) + "/images/"


def make_layout(msg_len):
    width = width_flag * msg_len if msg_len <= max_len else width_flag * max_len
    height = (math.ceil(msg_len / max_len) if math.ceil(max_len / max_len) > 0 else 1) * height_flag

    return Image.new('RGB', (width, height), "white")


def flag_by_char(ch):
    lat = {
        "А": "n", "Б": "h", "В": "b",
        "Г": "f", "Д": "z", "Е": "c",
        "Ё": "c", "Ж": "y", "З": "q",
        "И": "d", "Й": "d", "К": "x",
        "Л": "ll", "М": "l", "Н": "a",
        "О": "g", "П": "j", "Р": "p",
        "С": "e", "Т": "r", "У": "u",
        "Ф": "v", "Х": "i", "Ц": "s",
        "Ч": "m", "Ш": "sh", "Щ": "t",
        "Ь": "zn", "Ы": "k", "Ъ": "zn",
        "Э": "c", "Ю": "o", "Я": "w",
        " ": "space"
    }

    if ch.upper() in lat:
        return str(images_path) + lat[ch.upper()] + ".png"
    else:
        return str(images_path) + ch.lower() + ".png" if os.path.exists(str(images_path) + str(ch.lower()) + ".png") \
            else str(images_path) + "space.png"


def make_image(text):
    layout = make_layout(len(text))

    x_offset = 0
    y_offset = 0

    for i in range(0, len(text)):
        image_path = flag_by_char(text[i])
        flag = Image.open(image_path)

        layout.paste(flag, (x_offset, y_offset))
        if x_offset+width_flag == width_flag * max_len:
            x_offset = 0
            y_offset += height_flag
        else:
            x_offset += width_flag

    return layout


text = str(input("Your message: "))
image = make_image(text)

print("1. save")
print("2. show")

if int(input("Your choice: ")) == 2:
    image.show()
else:
    image.save(str(os.path.dirname(os.path.abspath(__file__)))+"/encode.png")
