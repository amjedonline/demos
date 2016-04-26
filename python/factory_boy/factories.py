import factory

from models import Cart

class CartFactory(factory.Factory):
    class Meta:
        model = Cart

    cart_id = "cart_id_123"
    version = "12345"

cart = CartFactory()
print(cart.cart_id)
print(cart.version)
print(cart.create_time);
