using Microsoft.AspNetCore.Razor.TagHelpers;

namespace DemoApp.TagHelpers;

//[HtmlTargetElement("span", Attributes = "time-format")]
[HtmlTargetElement("clock", Attributes = "time-format")]
public class ClockTagHelper : TagHelper
{
    public string TimeFormat { get; set; }

    public override void Process(TagHelperContext context, TagHelperOutput output)
    {
        var text = DateTime.Now.ToString(TimeFormat);
        output.TagName = "span";
        output.Content.SetContent(text); 
    }
}
