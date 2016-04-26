#!/usr/bin/env python3

import click

@click.command()
@click.option('-e', type=click.Choice(['live', 'staging']))
def cli(e):
    if not e:
        click.echo('Please provide the environment to deploy (live/staging).')
        return
    click.echo(e)

def main():
    cli()

if __name__ == '__main__':
    main()
