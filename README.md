# Give Me Hats

So I originally forked this mod to add more hats, but I've since decided to make it a bit more universal.

This mod allows to create custom hats, which can be used in the game.

## How to use

First you need to understand the structure of the hats.

- `config/givemehats/hats/*` contains files that will register each hat and adjust its position on your head.
- `resource pack` (it's literally a resource pack) contains the textures and models of the hats.
- `datapack` (it's literally a datapack) contains trinket support for the hats and recipes for crafting them.

### Creating a hat

To create a hat, you need to create a file in `config/givemehats/hats/` with the same name as the hat.

The file should look something like this:
```json
{
  "name": "bunny_ears",
  "display_name": "Bunny Ears",
  "model": "givemehats:item/bunny_ears",
  "scale": 1.0,
  "translation": [
    0.0,
    0.7,
    0.3
  ],
  "invert_x": true
}
```

- `name` is the name of the hat.
- `display_name` is the name that will be displayed in-game.
- `model` is the model of the hat.
- `scale` is the scale of the hat.
- `translation` is the translation of the hat.
- `invert_x` is a boolean that determines if the hat should be inverted on the X axis.

### Models and textures

A hats model and textures are located in `resource packs/givemehats/models/item` and `resource packs/givemehats/textures/block` respectively.

It's literally just the vanilla way of doing things.

### Trinket support

Trinkets are supported by using a datapack. 

You need to create a file at `datapacks/data/trinkets/entities/givemehats.json`.

The file should look like this:
```json
{
  "entities": [
    "player"
  ],
  "slots": [
    "head/hat"
  ]
}
```

Next you need to create a file at `datapacks/data/trinkets/tags/items/head/hat.json`.

The file should look like this:
```json
{
    "replace": false,
    "values": [
        "givemehats:bunny_ears"
    ]
}
```