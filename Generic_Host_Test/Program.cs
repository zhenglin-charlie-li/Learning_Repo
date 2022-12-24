using System.Reflection;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;

internal sealed class Program
{
    private static async Task Main(string[] args)
    {
        await Host.CreateDefaultBuilder(args)
            .UseContentRoot(Path.GetDirectoryName(Assembly.GetExecutingAssembly().Location))
            .ConfigureLogging(logging =>
            {
                // Add any 3rd party loggers like NLog or Serilog
            })
            .ConfigureServices(
                (hostContext, services) =>
                {
                    services.AddTransient<IHostedService, IWeatherService>();
                    services.AddHostedService<IWeatherService>();
                    services.AddHostedService<ConsoleHostedService>();
                }
            )
            .RunConsoleAsync();
    }
}

internal sealed class IWeatherService : IHostedService
{
    private readonly ILogger _logger;
    private readonly IHostApplicationLifetime _appLifetime;

    public IWeatherService(ILogger<IWeatherService> logger, IHostApplicationLifetime appLifetime)
    {
        _logger = logger;
        _appLifetime = appLifetime;
    }

    public Task StartAsync(CancellationToken cancellationToken)
    {
        _logger.LogDebug(
            $"Starting with arguments: {string.Join(" ", Environment.GetCommandLineArgs())}"
        );

        _appLifetime.ApplicationStarted.Register(() =>
        {
            Task.Run(async () =>
            {
                try
                {
                    _logger.LogInformation("Hello World!");

                    // Simulate real work is being done
                    await Task.Delay(1000);
                }
                catch (Exception ex)
                {
                    _logger.LogError(ex, "Unhandled exception!");
                }
                finally
                {
                    // Stop the application once the work is done
                    _appLifetime.StopApplication();
                }
            });
        });

        return Task.CompletedTask;
    }

    public Task StopAsync(CancellationToken cancellationToken)
    {
        return Task.CompletedTask;
    }

    internal int GetFiveDayTemperaturesAsync()
    {
        _logger.LogInformation("hello GetFiveDayTemperaturesAsync!");
        return 0;
    }
}

internal sealed class ConsoleHostedService : IHostedService
{
    private readonly ILogger _logger;
    private readonly IHostApplicationLifetime _appLifetime;
    private readonly IWeatherService _weatherService;

    public ConsoleHostedService(
        ILogger<ConsoleHostedService> logger,
        IHostApplicationLifetime appLifetime,
        IWeatherService weatherService
    )
    {
        _logger = logger;
        _appLifetime = appLifetime;
        _weatherService = weatherService;
    }

    public Task StartAsync(CancellationToken cancellationToken)
    {
        _logger.LogDebug(
            $"Starting with arguments: {string.Join(" ", Environment.GetCommandLineArgs())}"
        );
        _logger.LogInformation("Hello weatherService!");

        _appLifetime.ApplicationStarted.Register(() =>
        {
            Task.Run(() =>
            {
                try
                {
                    int result = _weatherService.GetFiveDayTemperaturesAsync();
                }
                catch (Exception ex)
                {
                    _logger.LogError(ex, "Unhandled exception!");
                }
                finally
                {
                    // Stop the application once the work is done
                    _appLifetime.StopApplication();
                }
            });
        });

        return Task.CompletedTask;
    }

    public Task StopAsync(CancellationToken cancellationToken)
    {
        return Task.CompletedTask;
    }
}
