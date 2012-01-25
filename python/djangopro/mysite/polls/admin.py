from mysite.polls.models import Poll
from mysite.polls.models import Choice

from django.contrib import admin

#class ChoiceInline(admin.StackedInline):
class ChoiceInline(admin.TabularInline):
	model = Choice
	extra = 3

class PollAdmin(admin.ModelAdmin):
	# Show the fields in the following order
	#fields = ['pub_date', 'question']

	#Use the corresponding label for each field
	fieldsets = [ 
	(None, {'fields': ['question']}),
	('Date information', {'fields':['pub_date'], 'classes':['collapse']}),
	]

	# Quickly add new choices while adding the poll
	inlines = [ChoiceInline]
	
	# In the 'Select a Poll to change' menu, display following fields for each poll
	list_display = ('question', 'pub_date', 'was_published_today')

	# Shows filter/facet for the below fields
	list_filter = ['pub_date']
	
	

admin.site.register(Poll, PollAdmin)
admin.site.register(Choice)
